### api-management

O endpoint do proxy também determina se os aplicativos acessam o proxy da API por HTTP ou HTTPS. Geralmente, você anexa políticas ao ProxyEndpoint para impor segurança, verificações de cotas e outros tipos de controle de acesso e limitação de taxa. 
TargetEndpoint: define a maneira como o proxy da API interage com seus serviços de back-end .

API PROXY VS API PROVIDER?

The API Provider provides a URL for an API instance provided through the API Proxy. B. The API Proxy acts as a proxy for all API instances provided through the API Provider

SAP BTP, API Management offers many out of the box API Security polices based on the Open Web Application Security Project (OWASP) API security best practices that can be customized for your enterprise requirements.

- [URL Masking](https://api.sap.com/policytemplate/URL_Masking)
- [SAP Cloud Platform API Management - API Security Best Practices Blog Series](https://community.sap.com/t5/technology-blogs-by-sap/sap-cloud-platform-api-management-api-security-best-practices-blog-series/ba-p/13313891)