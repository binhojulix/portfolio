# -*- coding: utf-8 -*-
from flask_sqlalchemy import SQLAlchemy
from sqlalchemy import func
from sqlalchemy.orm import relationship
from config import app_active, app_config

config = app_config[app_active]
db = SQLAlchemy(config.APP)


class Cenario(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    descricao = db.Column(db.String(40), unique=True, nullable=False)

    def get_cenarios(self):
        try:
            return Cenario.query.all()
        except Exception as e:
            print("Erro ao listar usuários.")
            return []

    def save(self):
        try:
            db.session.add(self)
            db.session.commit()
            return True
        except Exception as e:
            db.session.rollback()
            return False


    def obj_to_dict(self):  # for build json format
        return {
            "id": self.id,
            "descricao": self.descricao,
        }
