import pytest
import urllib3
import json


def test_fase_salvar_should_be_true_if_response_200():
    url = 'http://localhost:5000/fase'
    http = urllib3.PoolManager()
    fase = {'descricao': 'world11',
            "fk_sub_fase": 1,
            "subfase": {
                "descricao": "subfase300",
                "id": 1
            }
            }
    encoded_data = json.dumps(fase).encode('utf-8')
    headers = {'Content-type': 'application/json', 'Accept': 'application/json'}
    response = http.request("POST", url,  body=encoded_data,  headers=headers)
    assert response.status == 200

def test_fase_listar_should_be_true_if_response_200():
    url = 'http://localhost:5000/fases'
    http = urllib3.PoolManager()
    headers = {'Content-type': 'application/json', 'Accept': 'application/json'}
    response = http.request("GET", url, headers=headers)
    assert response.status == 200

def test_fase_listar_pagination_should_be_true_if_response_200():
    url = 'http://localhost:5000/fases'
    http = urllib3.PoolManager()
    headers = {'Content-type': 'application/json', 'Accept': 'application/json'}
    response = http.request("GET", url, headers=headers)
    assert response.status == 200

def test_fase_update_should_be_true_if_response_200():
    url = 'http://localhost:5000/fase'
    http = urllib3.PoolManager()
    fase = {'id':1005,
            'descricao': 'world11atualizado',
            "fk_sub_fase": 1,
            "subfase": {
                "descricao": "subfase300",
                "id": 1
            }
            }
    encoded_data = json.dumps(fase).encode('utf-8')
    headers = {'Content-type': 'application/json', 'Accept': 'application/json'}
    response = http.request("PATCH", url, body=encoded_data, headers=headers)
    assert response.status == 200

def test_fase_buscar_should_be_true_if_response_200():
    url = 'http://localhost:5000/fase/1004'
    http = urllib3.PoolManager()
    headers = {'Content-type': 'application/json', 'Accept': 'application/json'}
    response = http.request("GET", url, headers=headers)
    assert response.status == 200


def test_fase_deletar_should_be_true_if_response_200():
    url = 'http://localhost:5000/fase/1005'
    http = urllib3.PoolManager()
    headers = {'Content-type': 'application/json', 'Accept': 'application/json'}
    response = http.request("DELETE", url, headers=headers)
    assert response.status == 200