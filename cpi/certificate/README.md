# Certificados

Este documento visa explicar como gerar e utilizar certificados do Integration Suite e estabelecer uma conexão segura com o sistema backend, especificamente dentro da transação `STRUST`, sem depender da autenticação do tipo `Basic`.

Essas medidas trazem uma comunicação mais eficiente e segura, além de garantir a rastreabilidade das interações entre os sistemas, proporcionando maior transparência e controle sobre as operações.

- [Certificados](#certificados)
    - [`service-key` do tipo certificado](#service-key-do-tipo-certificado)
    - [Chaves públicas e privadas](#chaves-públicas-e-privadas)
      - [Formatação](#formatação)
      - [RSA public key](#rsa-public-key)
      - [RSA private key](#rsa-private-key)
    - [Personal Information Exchange - `.pfx`](#personal-information-exchange---pfx)
    - [Importar `PSE` (`.pfx`) em `STRUST`](#importar-pse-pfx-em-strust)
    - [Referências](#referências)

![.images/img-11.png](.images/img-11.png)


### `service-key` do tipo certificado

> Atenção, o certificado já foi criado anteriormente, e não há necessidade de criação de um novo. Em caso de dúvidas, entrar em contato com basis@atem.com.br

Na subaccount que contém o serviço de plataforma Integration Suite:

- Acesse a service instance `integration-flow`
- Crie uma `service-key` do tipo **Certificado**.

![.images/img-01.png](.images/img-01.png)

Após, as chave da credencial são disponibilizadas em formato JSON. Clique em **Download** para gravar o arquivo localmente.

![.images/img-02.png](.images/img-02.png)


### Chaves públicas e privadas

Próximos passos consistem em identificar os certificados e do par de chaves (key pair), formatá-los e gravá-los em arquivos separados.


#### Formatação

Abra o arquivo que contém o certificado baixado anteriormente, e localize o atributo `certificate`: 

- Copie seu valor (começa com `-----BEGIN CERTIFICATE-----` e termina com `-----END CERTIFICADO-----\n`)
- Cole em algum editor de texto/código (usei `VS Code`).
- Formate o certificado substituindo todas as ocorrências `\n` por quebras de linha.

![.images/img-03.png](.images/img-03.png)

Ao fim, o certificado deve estar semelhante ao da imagem abaixo

![.images/img-04.png](.images/img-04.png)

Existem 3 certificados agrupados em um – isso ocorre porque a instância de serviço `Process Integration Runtime` gera uma cadeia de certificados codificada em PEM. 

> A cadeia de certificados contém um certificado raiz que é compatível com o SAP (veja [**Load Balancer Root Certificates Supported by SAP**](https://help.sap.com/docs/CLOUD_INTEGRATION/368c481cd6954bdfa5d0435479fd4eaf/4509f605e83c4c939a91b81eb3a6cdea.html??locale=en-US)).


#### RSA public key

Grave a cadeia de 3 certificados  (começa com `-----BEGIN CERTIFICATE-----` e termina com `-----END CERTIFICADO-----\n`) em um arquivo com extensão `.pem` – eg.: `cert.cem`.

> O arquivo `.cem` deve conter os 3 certificados.

![.images/img-05.png](.images/img-05.png)


#### RSA private key

Localize o atributo `key` no mesmo arquivo `.txt` de certificados (começa com `-----BEGIN RSA PRIVATE KEY-----` e termina com `-----END RSA PRIVATE KEY-----\ n`), cole o valor em um editor de texto/código e substitua todas as ocorrências de `\n` para que fique semelhante com a imagem abaixo:

![.images/img-06.png](.images/img-06.png)

Grave o certificado privado em um arquivo com extensão `.key` – eg.: `cert.key`.

> O arquivo `.key` deve conter apenas a chave privada

![.images/img-07.png](.images/img-07.png)


### Personal Information Exchange - `.pfx`

Para estabelecer conectividade entre S/4 HANA e o Integration Suite (CPI), é necessário importar as chaves públicas e privada no sistema S/4 HANA através da transação `STRUST`.

Para isso, é preciso gerar um arquivo `.pfx` a partir dos arquivos `.cem` e `.key`, utilizando a ferramenta CLI `openssl`, da seguinte forma:

```
openssl pkcs12 -export -inkey ca-certs.key -in ca-certs.cem -out ca-certs.pfx
```

> Durante a criaçao, é necessário gerar uma senha para a chave. **Esta senha será necessária ao importar a chave no S/4 HANA**


### Importar `PSE` (`.pfx`) em `STRUST`

- Acessar a transação `STRUST`
- Em modo de edição, vá até ao menu `PSE` > `Importar`
- Selecione o arquivo `.pfx`
- Informe a senha da chave, a mesma criada em _[Personal Information Exchange](#personal-information-exchange)_
- Vá novamente no menu, e selecione `PSE` > `Gravar como`

![.images/img-08.png](.images/img-08.png)

  - Selecione `CPI` na opcação `SSL client`

![.images/img-09.png](.images/img-09.png)

  - Após, o certificado é importado

![.images/img-10.png](.images/img-10.png)

**Se voce chegou até aqui, parabéns! Já pode se considerar o mais novo senior master blaster em certificados**


### Referências

- [Step-by-step Guide to Set Up Inbound Client Certificate Authentication, Cloud Foundry Environment](https://community.sap.com/t5/technology-blogs-by-sap/step-by-step-guide-to-set-up-inbound-client-certificate-authentication/ba-p/13534450)
- [Openssl](https://www.openssl.org/)