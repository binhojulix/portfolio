# -*- coding: utf-8 -*-
from flask import Flask
from flask_cors import CORS
import logging

# config import
from routes.gateway import base_routes
from config import app_config, app_active
from flask_sqlalchemy import SQLAlchemy
from flask_migrate import Migrate

config = app_config[app_active]


def create_app(config_name):
    app = Flask(__name__)
    app.config.from_object(app_config[config_name])
    app.config.from_pyfile('config.py')
    
    app.config['SQLALCHEMY_DATABASE_URI'] = config.SQLALCHEMY_DATABASE_POSTGRES
    app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
    db = SQLAlchemy(config.APP)
    base_routes(app)

    migrate = Migrate(app, db)
    CORS(app)

    db.init_app(app)

    @app.route("/")
    def index():
        logging.info('This is an info message')
        return "Flask inside Docker!!"

    return app
