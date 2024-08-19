use papelaria;

INSERT INTO CLIENTE (CPF, NOME, ENDERECO, EMAIL) 
VALUES	(12345678901, 'João Silva', 'Rua A, 123', 'joao.silva@email.com'),
		(23456789012, 'Maria Santos', 'Av. B, 456', 'maria.santos@email.com'),
		(34567890123, 'Pedro Oliveira', 'Travessa C, 789', 'pedro.oliveira@email.com'),
		(45678901234, 'Ana Souza', 'Praça D, 321', 'ana.souza@email.com'),
		(56789012345, 'Carlos Pereira', 'Alameda E, 654', 'carlos.pereira@email.com'),
		(67890123456, 'Juliana Martins', 'Viela F, 987', 'juliana.martins@email.com'),
		(78901234567, 'Fernando Santos', 'Rua G, 111', 'fernando.santos@email.com'),
		(89012345678, 'Amanda Costa', 'Av. H, 222', 'amanda.costa@email.com'),
		(90123456789, 'Rafaela Oliveira', 'Travessa I, 333', 'rafaela.oliveira@email.com'),
		(11223344556, 'Lucas Silva', 'Praça J, 444', 'lucas.silva@email.com'),
		(22334455667, 'Patrícia Mendes', 'Alameda K, 555', 'patricia.mendes@email.com'),
		(33445566778, 'Roberto Almeida', 'Viela L, 666', 'roberto.almeida@email.com'),
		(44556677889, 'Mariana Lima', 'Rua M, 777', 'mariana.lima@email.com'),
		(55667788990, 'Gustavo Santos', 'Av. N, 888', 'gustavo.santos@email.com'),
		(66778899001, 'Carolina Sousa', 'Travessa O, 999', 'carolina.sousa@email.com'),
		(77889900112, 'Paulo Oliveira', 'Praça P, 000', 'paulo.oliveira@email.com'),
		(88990011223, 'Vanessa Silva', 'Alameda Q, 123', 'vanessa.silva@email.com'),
		(99001122334, 'Rodrigo Pereira', 'Viela R, 234', 'rodrigo.pereira@email.com'),
		(33445566888, 'Sandra Almeida', 'Rua S, 345', 'sandra.almeida@email.com'),
		(11223344566, 'Felipe Mendes', 'Av. T, 456', 'felipe.mendes@email.com');
        
        
INSERT INTO FUNCIONARIO (NOMEFUNCIONARIO, FUNCAO, EMAIL)
VALUES	('João Silva', 'Vendedor', 'joao.silva@example.com'),
		('Maria Santos', 'Vendedor', 'maria.santos@example.com'),
		('Pedro Oliveira', 'Vendedor', 'pedro.oliveira@example.com'),
		('Ana Souza', 'Caixa', 'ana.souza@example.com'),
		('Carlos Pereira', 'Vendedor', 'carlos.pereira@example.com'),
		('Juliana Martins', 'Auxiliar de estoque', 'juliana.martins@example.com'),
		('Fernando Santos', 'Caixa', 'fernando.santos@example.com'),
		('Amanda Costa', 'Gerente', 'amanda.costa@example.com'),
		('Rafaela Oliveira', 'Televendas', 'rafaela.oliveira@example.com'),
		('Lucas Silva', 'Serviços Gerais', 'lucas.silva@example.com');
        
INSERT INTO FORNECEDOR (CNPJ, NOMEFORNECEDOR, TELEFONE, ENDERECOFORNECEDOR) 
VALUES	('12345678000100', 'Fornecedor A', 1122334455, 'Rua A, 123'),
		('23456789000123', 'Fornecedor B', 9988776655, 'Av. B, 456'),
		('34567890000134', 'Fornecedor C', 5544332211, 'Travessa C, 789'),
		('45678901000145', 'Fornecedor D', 8877665544, 'Praça D, 321'),
		('56789012000156', 'Fornecedor E', 2233445566, 'Alameda E, 654'),
		('67890123000167', 'Fornecedor F', 6655443322, 'Viela F, 987'),
		('78901234000178', 'Fornecedor G', 9988776655, 'Rua G, 111'),
		('89012345000189', 'Fornecedor H', 1122334455, 'Av. H, 222'),
		('90123456000190', 'Fornecedor I', 5544332211, 'Travessa I, 333'),
		('11223344500011', 'Fornecedor J', 8877665544, 'Praça J, 444'),
		('22334455600022', 'Fornecedor K', 2233445566, 'Alameda K, 555'),
		('33445566700033', 'Fornecedor L', 6655443322, 'Viela L, 666'),
		('44556677800044', 'Fornecedor M', 9988776655, 'Rua M, 777'),
		('55667788900055', 'Fornecedor N', 1122334455, 'Av. N, 888'),
		('66778899000066', 'Fornecedor O', 5544332211, 'Travessa O, 999'),
		('77889900100077', 'Fornecedor P', 8877665544, 'Praça P, 000'),
		('88990011200088', 'Fornecedor Q', 2233445566, 'Alameda Q, 123'),
		('99001122300099', 'Fornecedor R', 6655443322, 'Viela R, 234'),
		('33445566700100', 'Fornecedor S', 9988776655, 'Rua S, 345'),
		('11223344500111', 'Fornecedor T', 1122334455, 'Av. T, 456');

INSERT INTO PRODUTO (PRECO, VALIDADE, NOMEPRODUTO, DESCRICAO, QUANTIDADE, CNPJ) 
VALUES	(10.50, '2025-06-30', 'Caneta Esferográfica Azul', 'Caneta esferográfica de ponta média, tinta azul.', 100, '12345678000100'),
		(5.75, '2024-12-31', 'Caderno Universitário 200 folhas', 'Caderno universitário com capa dura, pauta interna e 200 folhas.', 50, '23456789000123'),
		(3.25, '2023-08-15', 'Lápis HB Nº2', 'Lápis com grafite HB Nº2, ideal para escrita.', 200, '34567890000134'),
		(15.90, '2025-04-20', 'Borracha Branca', 'Borracha branca macia, fácil de apagar.', 150, '45678901000145'),
		(20.00, '2024-11-30', 'Marcador de Texto Amarelo', 'Marcador de texto amarelo fluorescente.', 80, '56789012000156'),
		(7.99, '2023-12-31', 'Agenda Diária 2024', 'Agenda diária para o ano de 2024, com capa flexível.', 30, '67890123000167'),
		(12.50, '2025-02-28', 'Pasta Catálogo A4', 'Pasta catálogo A4 com 100 folhas transparentes.', 40, '78901234000178'),
		(8.75, '2024-09-15', 'Caneta Marca Texto Verde', 'Caneta marca texto verde fluorescente.', 70, '89012345000189'),
		(6.49, '2023-10-31', 'Tesoura Escolar', 'Tesoura escolar com pontas arredondadas, ideal para uso seguro por crianças.', 90, '90123456000190'),
		(18.75, '2025-03-31', 'Calculadora Científica', 'Calculadora científica com funções trigonométricas e estatísticas.', 25, '11223344500011'),
		(4.99, '2023-07-15', 'Apontador com Depósito', 'Apontador de lápis com depósito para as aparas.', 120, '22334455600022'),
		(2.99, '2024-10-30', 'Borracha Colorida', 'Borracha colorida em formato de animal, ideal para uso escolar.', 180, '33445566700033'),
		(9.25, '2025-01-31', 'Caneta Gel Azul', 'Caneta gel azul de escrita suave.', 60, '44556677800044'),
		(14.50, '2024-08-31', 'Mochila Escolar', 'Mochila escolar com compartimento para notebook e alças acolchoadas.', 35, '55667788900055'),
		(22.99, '2025-05-31', 'Giz de Cera 12 Cores', 'Giz de cera com 12 cores diferentes.', 100, '66778899000066'),
		(3.75, '2024-07-31', 'Régua 30 cm', 'Régua escolar de 30 cm em plástico transparente.', 200, '77889900100077'),
		(5.00, '2023-11-15', 'Lápis de Cor 24 Cores', 'Lápis de cor com 24 cores vibrantes.', 150, '88990011200088'),
		(6.99, '2024-06-30', 'Corretivo Líquido', 'Corretivo líquido de secagem rápida.', 80, '99001122300099'),
		(11.25, '2025-03-15', 'Papel Sulfite A4 500 folhas', 'Papel sulfite A4 branco, 75g/m², pacote com 500 folhas.', 50, '33445566700100'),
		(9.99, '2024-09-30', 'Estojo Escolar', 'Estojo escolar com divisórias para lápis e acessórios.', 70, '11223344500111');



INSERT INTO VENDAS(MATRICULA, CPF)
VALUES 	(1000,11223344556),
		(1000,11223344566),
        (1000,12345678901),
        (1000,22334455667),
        (1001,23456789012),
        (1001,55667788990),
        (1001,12345678901),
        (1002,56789012345),
        (1002,67890123456),
        (1002,77889900112);

INSERT INTO LISTAPRODUTOS(IDVENDA, CODIGO, QNTVENDIDO)
VALUES	(10000, 106, 2),
		(10000, 104, 1),
        (10001, 106, 3),
        (10002, 100, 5),
        (10003, 118, 2),
        (10003, 114, 10),
        (10003, 115, 2),
        (10004, 109, 1),
        (10004, 111, 2),
        (10004, 112, 5);