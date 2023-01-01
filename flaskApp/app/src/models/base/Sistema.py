# -*- coding: utf-8 -*-
from flask_sqlalchemy import SQLAlchemy
from sqlalchemy import func
from sqlalchemy.orm import relationship
from config import app_active, app_config

config = app_config[app_active]
db = SQLAlchemy(config.APP)


class Sistema(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    nome = db.Column(db.String(40), unique=True, nullable=False)

    id = db.Column(db.Integer, primary_key=True)
    nome = db.Column(db.String(40), unique=True, nullable=False)

    def get_Ativos(self):
        try:
            return Sistema.query.all()
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

    def delete(self):
        try:
            db.session.remove(self)
            db.session.commit()
        except Exception as e:
            db.session.rollback()

    def find(self):
        try:
            Sistema.query.get(self)
        except Exception as e:
            print("error in search")

    def update(self):
        try:
            Sistema.query.update(self)
        except Exception as e:
            print("updated")


    def obj_to_dict(self):  # for build json format
        return {
            "id": self.id,
            "nome": self.nome,
        }
