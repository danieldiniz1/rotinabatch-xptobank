﻿# rotinabatch-xptobank
Aplicação que simula uma rotina com sprirng batch de um banco xpto que avalia o cliente e com base em sua faixa salarial, atribui a conta um valor especifico de acordo com as regras de negócio.
Implementação usando leitura jdbc (ItemReader) e processadores no padrãod e classificação e design pattern de strategy (ItemProcessor que avalia qual classe deve ser implementada de acordo com a faixa do cliente e consequentemente, aplicada a regra de negócio).
