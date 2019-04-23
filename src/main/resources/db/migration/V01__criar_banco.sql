DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS papel;
DROP TABLE IF EXISTS papel_usuario;

DROP TABLE IF EXISTS produto;

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nome VARCHAR(80) NOT NULL,
    usuario VARCHAR(15) NOT NULL,
    senha VARCHAR(80) NOT NULL,
    ativo BOOLEAN NOT NULL
);
INSERT INTO usuario (nome, usuario, senha, ativo) VALUES
('Usuario Admin', 'admin', '$2a$10$6.4isPLYJF0p4IpjXzZ90eLQfn4st5OrXcSTP1hTUNPr0MsY6xMom', true),
('Usuario Oper', 'oper', '$2a$10$YO1V54X794MFat4tsoSmaO82Nbpt.W8LGwtLNs5EQmc7VBQ03ESC.', true);

CREATE TABLE papel (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nome VARCHAR(20)
);
INSERT INTO papel (nome) VALUES
('ROLE_ADMIN'),('ROLE_OPER');

CREATE TABLE papel_usuario (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    id_usuario INT NOT NULL,
    id_papel INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_papel) REFERENCES papel(id)
);
INSERT INTO papel_usuario (id_usuario, id_papel) VALUES
(1,1),(2,2);

CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nome VARCHAR(80) NOT NULL
);
INSERT INTO produto (nome) VALUES
('Produto1'),('Produto2');