terraform {
    required_providers{
        azurerm={
            source="hashicorp/azurerm"
            version="2.46.0"
        }
    }
}

provider "azurerm" {
  feature{

  }
}

resource "azurerm_resource_group" "app_cma_k8s" {
  name = "app_cma_k8s"
  location = "brasil"
}