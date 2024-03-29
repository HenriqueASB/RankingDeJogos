USE ranking;

DROP TABLE IF EXISTS user;
CREATE TABLE user (
	id int unsigned NOT NULL AUTO_INCREMENT,
	nome varchar(45) NOT NULL,
	email varchar(45) NOT NULL,
	senha varchar(45) NOT NULL,
	urlFoto varchar(100) DEFAULT NULL,
	PRIMARY KEY (id),
	UNIQUE KEY id_UNIQUE (id),
	UNIQUE KEY email_UNIQUE (email)
);

DROP TABLE IF EXISTS empresa;
CREATE TABLE empresa (
	id int unsigned  NOT NULL AUTO_INCREMENT,
	nome varchar(50) NOT NULL,
	ano varchar(4) NOT NULL,
	PRIMARY KEY (id),
    UNIQUE KEY id_UNIQUE (id),
    UNIQUE KEY nome_UNIQUE (nome)
);

DROP TABLE IF EXISTS genero;
CREATE TABLE genero (
	id int unsigned  NOT NULL AUTO_INCREMENT,
	genero varchar(30) NOT NULL,
	PRIMARY KEY (id),
    UNIQUE KEY id_UNIQUE (id),
    UNIQUE KEY genero_UNIQUE (genero)
);

DROP TABLE IF EXISTS console;
CREATE TABLE console (
	id int unsigned  NOT NULL AUTO_INCREMENT,
	nome varchar(30) NOT NULL,
	fabricante varchar(30),
	ano varchar(4),
	PRIMARY KEY (id),
    UNIQUE KEY id_UNIQUE (id),
    UNIQUE KEY nome_UNIQUE (nome)
);

DROP TABLE IF EXISTS jogo;
CREATE TABLE jogo (
	id int unsigned  NOT NULL AUTO_INCREMENT,
	titulo varchar(50) NOT NULL,
	empresa_id int unsigned  NOT NULL,
	sinopse varchar(255) NOT NULL,
	urlFoto varchar(100) DEFAULT NULL,
	PRIMARY KEY (id),
    UNIQUE KEY id_UNIQUE (id),
    UNIQUE KEY titulo_UNIQUE (titulo)
);

DROP TABLE IF EXISTS jogo_genero;
CREATE TABLE jogo_genero (
	jogo_id int unsigned  NOT NULL,
	genero_id int unsigned  NOT NULL
);

DROP TABLE IF EXISTS jogo_console;
CREATE TABLE jogo_console (
	jogo_id int unsigned  NOT NULL,
	console_id int unsigned  NOT NULL
);

DROP TABLE IF EXISTS avaliacao;
CREATE TABLE avaliacao (
	id int unsigned  NOT NULL AUTO_INCREMENT,
	user_id int unsigned  NOT NULL,
	jogo_id int unsigned  NOT NULL,
	nota int  unsigned  NOT NULL,
	PRIMARY KEY (id),
    UNIQUE KEY id_UNIQUE (id)
);

