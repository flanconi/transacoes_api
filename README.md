## Projeto IBM API

## Query SQL 

```
CREATE TABLE `transacoes` (
  `idtransacao` int NOT NULL AUTO_INCREMENT,
  `transacao` varchar(45) NOT NULL,
  PRIMARY KEY (`idtransacao`)
  ); 
```

## /transacao

`GET` Retorna uma lista com todas as informações sobre as transações; 

`POST`  Insere dados de transação na tabela podendo adicionar mais de um bloco de informações; 
   + Body:
          [
            {
              "transacao": "2023-04-12,-10.00,cultura"
            }
           ]

`PUT` Altera o dado da tabelar a partir de um id que é passado body da chamada;<br>
+ Body:
          [
            {
             "id": 4,
		          "transacao": "2023-04-25,30.00,alimentacao"
            }
           ]
  
`DELETE` Apaga o dado da tabelar a partir de um id que é passado com parametro na url;


## /transacao
`GET` Retorna uma lista com o valor total gasto em uma categoria de transação, este valor é acessado apartir do parametro **categoria** que é passado na url; 

