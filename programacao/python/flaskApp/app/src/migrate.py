from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from flask_script import Manager
from flask_migrate import Migrate, MigrateCommand
from app.src.config import app_active, app_config

config = app_config[app_active]

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = config.SQLALCHEMY_DATABASE_URI
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False

db = SQLAlchemy(app)
migrate = Migrate(app, db)

manager = Manager(app)
manager.add_command('db', MigrateCommand)


class Subfase(db.Model):
    __tablename__ = 'subfase'
    id_sub_fase = db.Column(db.Integer, primary_key=True)
    descricao_sub_fase = db.Column(db.String(40), unique=True, nullable=False)

class Fase(db.Model):
    __tablename__ = 'fase'
    id_fase = db.Column(db.Integer, primary_key=True)
    descricao_fase = db.Column(db.String(40), unique=True, nullable=False)
    id_sub_fase = db.Column(db.Integer, db.ForeignKey(Subfase.id_sub_fase))



if __name__ == '__main__':
    manager.run()