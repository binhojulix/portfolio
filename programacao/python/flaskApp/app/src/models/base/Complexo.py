# -*- coding: utf-8 -*-
from flask_sqlalchemy import SQLAlchemy
from sqlalchemy import func
from sqlalchemy.orm import relationship, joinedload
from config import app_active, app_config
from sqlalchemy.orm import backref


config = app_config[app_active]
db = SQLAlchemy(config.APP)


class Complexo(db.Model):
    __tablename__ = 'complexo'
    id = db.Column('id_complexo', db.Integer, primary_key=True)
    descricao = db.Column('descricao_complexo', db.String(40), unique=True, nullable=False)



    def get_complexos(self):
        try:
            return Complexo.query.all()
        except Exception as e:
            print("Erro ao listar complexos.")
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
            db.session.query(Complexo).filter(Complexo.id == self.id).delete()
            db.session.commit()
            return True
        except Exception as e:
            return False

    def find(self):
        try:
            res = db.session.query(Complexo).filter(Complexo.id == self.id).first()
        except Exception as e:
            res = []
            print(e)
        finally:
            db.session.close()
            return res

    def update(self, obj):
        try:
            db.session.query(Complexo).filter(Complexo.id == self.id).update(obj)
            db.session.commit()
            return True
        except Exception as e:
            print(e)
            db.session.rollback()
            return False


    def obj_to_dict(self):  # for build json format
        return {
            "id": self.id,
            "descricao": self.descricao
        }

    def __repr__(self):
        return '%s	-	%s' % (self.id, self.descricao)