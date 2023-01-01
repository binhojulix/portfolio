from routes.base.FaseRouter import routes_fases
from routes.base.SubfaseRouter import routes_subfases


def base_routes(app):
    routes_fases(app)
    routes_subfases(app)

