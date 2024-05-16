# Como criar proxy `XI`

- Protocolo: `XI`
- Tipo de comunicação: `Sincrono`

## Visão geral

Os passos seguintes descrevem o processo de criação do proxy, tomando como base em um namespace previamente já estabelecido.


## Índice

- [Como criar proxy `XI`](#como-criar-proxy-xi)
  - [Visão geral](#visão-geral)
  - [Índice](#índice)
    - [Service Interface](#service-interface)
    - [Message Type Request](#message-type-request)
    - [Message Type Response](#message-type-response)


### Service Interface

- "Object Type"
  - `Service Consumer` (Service Interface)

![image-01-01](.images/como-criar-proxy-xi-sync/img-01-01.png)

- "Generation Source"
  - `Backend`

![image-01-02](.images/como-criar-proxy-xi-sync/img-01-02.png)

- "Service Interface"
  - `Name`
  - `Namespace`

![image-01-03](.images/como-criar-proxy-xi-sync/img-01-03.png)

- "Operation"
  - `EXECUTE`
 
![image-01-04](.images/como-criar-proxy-xi-sync/img-01-04.png)
<!-- ![image-02-05](.images/img-02-05.png) -->


### Message Type Request

- Criar `Message Type`
  - `MT_S4_Sample_XI_Sync_Req`

![image-01-06](.images/como-criar-proxy-xi-sync/img-01-06.png)
![image-01-07](.images/como-criar-proxy-xi-sync/img-01-07.png)

- Criar `Data Type`
  - `DT_S4_Sample_SOAP_Sync_Req`

![image-01-08](.images/como-criar-proxy-xi-sync/img-01-08.png)
![image-01-09](.images/como-criar-proxy-xi-sync/img-01-09.png)
![image-01-10](.images/como-criar-proxy-xi-sync/img-01-10.png)

- Adicionar segmentos no data type criado
  - `id`

![image-01-11](.images/como-criar-proxy-xi-sync/img-01-11.png)
![image-01-12](.images/como-criar-proxy-xi-sync/img-01-12.png)


### Message Type Response

- Criar `Message Type`
  - `MT_S4_Sample_SOAP_Sync_Res`

![image-01-13](.images/como-criar-proxy-xi-sync/img-01-13.png) 
![image-01-14](.images/como-criar-proxy-xi-sync/img-01-14.png)

- Criar `Data Type`
  - `DT_S4_Sample_SOAP_Sync_Res`

![image-01-15](.images/como-criar-proxy-xi-sync/img-01-15.png)
![image-01-16](.images/como-criar-proxy-xi-sync/img-01-16.png)
![image-01-17](.images/como-criar-proxy-xi-sync/img-01-17.png)

- Adicionar segmentos no data type criado
  - `id`
  - `name`
  - `username`
  - `email`

![image-01-18](.images/como-criar-proxy-xi-sync/img-01-18.png)