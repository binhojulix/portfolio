import pytest
import urllib3
import json


def test_subfase_salvar_should_be_true_if_response_200():
    url = 'http://localhost:5000/subfase'
    http = urllib3.PoolManager()
    subfase = {'descricao': 'world55'}
    encoded_data = json.dumps(subfase).encode('utf-8')
    headers = {'Content-type': 'application/json', 'Accept': 'application/json'}
    response = http.request("POST", url,  body=encoded_data,  headers=headers)
    assert response.status == 200

def test_subfase_listar_should_be_true_if_response_200():
    url = 'http://localhost:5000/subfases'
    http = urllib3.PoolManager()
    headers = {'Content-type': 'application/json', 'Accept': 'application/json'}
    response = http.request("GET", url, headers=headers)
    assert response.status == 200

