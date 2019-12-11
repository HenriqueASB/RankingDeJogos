USE ranking;

INSERT INTO `ranking`.`empresa`
(`nome`,
`ano`)
VALUES
('Atari','1972'),
('Activision Blizzard','2008'),
('Bandai Namco','2006'),
('Bethesda Game Studios','2001'),
('BioWare','1995'),
('Capcom','1979'),
('Electronic Arts','1982'),
('Microsoft','1975'),
('Naughty Dog','1984'),
('Nintendo', '1889'),
('Rockstar Games','1998'),
('SEGA','1960'),
('Sony Computer Entertainment','1993'),
('Square Enix','1975'),
('Ubisoft','1986'),
('Valve','1996');

INSERT INTO `ranking`.`genero`
(`genero`)
VALUES
('Ação'),
('Aventura'),
('Estratégia'),
('FPS'),
('RPG'),
('Esporte'),
('Simulação'),
('Plataforma'),
('Puzzle');

INSERT INTO `ranking`.`console`
(`nome`,
`fabricante`,
`ano`)
VALUES
('PC','Alan Mathison Turing','1938'),
('Atari 2600','Atari','1977'),
('Game & Watch','Nintendo','1980'),
('NES','Nintendo','1983'),
('Master System','Sega','1987'),
('Game Boy','Nintendo','1989'),
('Mega Drive','Sega','1988'),
('Super Nintendo','Nintendo','1990'),
('PlayStation','Sony','1994'),
('Nintendo 64','Nintendo','1996'),
('PlayStation 2','Sony','2000'),
('Nintendo GameCube','Nintendo','2001'),
('Xbox','Microsoft','2001'),
('Xbox 360','Microsoft','2005'),
('PlayStation 3','Sony','2006'),
('Wii','Nintendo','2006'),
('Nintendo Wii U','Nintendo','2012'),
('PlayStation 4','Sony','2013'),
('Xbox One','Microsoft','2013'),
('Nintendo Switch','Nintendo','2017');

# Inserir um jogo requer o preenchimento de três tabelas
# jogo, jogo_console, jogo_genero

######### Exemplo de jogo 1 ###########
# Insert na tabela jogo
INSERT INTO `ranking`.`jogo`
(`titulo`,
`empresa_id`,
`sinopse`,
`urlFoto`)
VALUES
('Pacman',
(SELECT `id`
FROM `ranking`.`empresa`
WHERE `nome` = 'Bandai Namco'),
'Jogo de 1980 no qual o jogador controla uma cabeça redonda em um labirinto repleto de pastilhas e 4 fantasmas que o perseguem.',
'assets/images/jogos/pacman.jpg');

# Insert na tabela jogo_genero
INSERT INTO `ranking`.`jogo_genero`
(`jogo_id`,
`genero_id`)
VALUES
((SELECT `id`
FROM `ranking`.`jogo`
WHERE `titulo` = 'Pacman'),
(SELECT `id`
FROM `ranking`.`genero`
WHERE `genero` = 'Plataforma'));

# Insert na tabela jogo_console
INSERT INTO `ranking`.`jogo_console`
(`jogo_id`,
`console_id`)
VALUES
((SELECT `id`
FROM `ranking`.`jogo`
WHERE `titulo` = 'Pacman'),
(SELECT `id`
FROM `ranking`.`console`
WHERE `nome` = 'Atari 2600'));

######### Exemplo de jogo 2 ###########
# Insert na tabela jogo
INSERT INTO `ranking`.`jogo`
(`titulo`,
`empresa_id`,
`sinopse`,
`urlFoto`)
VALUES
('Super Mario Bros.',
(SELECT `id`
FROM `ranking`.`empresa`
WHERE `nome` = 'Nintendo'),
'Jogo de 1985 no qual o jogador controla um encanador pelo Reino do Cogumelo para salvar a Princesa Peach do domínio dos Koopa Troopas.',
'assets/images/jogos/mario.jpg');

# Insert na tabela jogo_genero
INSERT INTO `ranking`.`jogo_genero`
(`jogo_id`,
`genero_id`)
VALUES
((SELECT `id`
FROM `ranking`.`jogo`
WHERE `titulo` = 'Super Mario Bros.'),
(SELECT `id`
FROM `ranking`.`genero`
WHERE `genero` = 'Aventura')),
((SELECT `id`
FROM `ranking`.`jogo`
WHERE `titulo` = 'Super Mario Bros.'),
(SELECT `id`
FROM `ranking`.`genero`
WHERE `genero` = 'Plataforma'));

# Insert na tabela jogo_console
INSERT INTO `ranking`.`jogo_console`
(`jogo_id`,
`console_id`)
VALUES
((SELECT `id`
FROM `ranking`.`jogo`
WHERE `titulo` = 'Super Mario Bros.'),
(SELECT `id`
FROM `ranking`.`console`
WHERE `nome` = 'NES'));

######### Exemplo de jogo 3 ###########
# Insert na tabela jogo
INSERT INTO `ranking`.`jogo`
(`titulo`,
`empresa_id`,
`sinopse`,
`urlFoto`)
VALUES
('Sonic the Hedgehog',
(SELECT `id`
FROM `ranking`.`empresa`
WHERE `nome` = 'SEGA'),
'Jogo de 1991 no qual o jogador controla um ouriço antropomórfico azul contra as ameaças do gênio do mal Dr. Ivo "Eggman" Robotnik.',
'assets/images/jogos/sonic.jpg');

# Insert na tabela jogo_genero
INSERT INTO `ranking`.`jogo_genero`
(`jogo_id`,
`genero_id`)
VALUES
((SELECT `id`
FROM `ranking`.`jogo`
WHERE `titulo` = 'Sonic the Hedgehog'),
(SELECT `id`
FROM `ranking`.`genero`
WHERE `genero` = 'Aventura')),
((SELECT `id`
FROM `ranking`.`jogo`
WHERE `titulo` = 'Sonic the Hedgehog'),
(SELECT `id`
FROM `ranking`.`genero`
WHERE `genero` = 'Plataforma'));

# Insert na tabela jogo_console
INSERT INTO `ranking`.`jogo_console`
(`jogo_id`,
`console_id`)
VALUES
((SELECT `id`
FROM `ranking`.`jogo`
WHERE `titulo` = 'Sonic the Hedgehog'),
(SELECT `id`
FROM `ranking`.`console`
WHERE `nome` = 'Mega Drive'));

######### Exemplo de jogo 4 ###########
# Insert na tabela jogo
INSERT INTO `ranking`.`jogo`
(`titulo`,
`empresa_id`,
`sinopse`,
`urlFoto`)
VALUES
('The Legend of Zelda: Ocarina of Time',
(SELECT `id`
FROM `ranking`.`empresa`
WHERE `nome` = 'Nintendo'),
'Jogo de 1998 no qual o jogador controla o elfo Link pela fantástica Hyrule, numa demanda para impedir que Ganondorf obtenha a Triforça.',
'assets/images/jogos/zelda.jpg');

# Insert na tabela jogo_genero
INSERT INTO `ranking`.`jogo_genero`
(`jogo_id`,
`genero_id`)
VALUES
((SELECT `id`
FROM `ranking`.`jogo`
WHERE `titulo` = 'The Legend of Zelda: Ocarina of Time'),
(SELECT `id`
FROM `ranking`.`genero`
WHERE `genero` = 'Aventura')),
((SELECT `id`
FROM `ranking`.`jogo`
WHERE `titulo` = 'The Legend of Zelda: Ocarina of Time'),
(SELECT `id`
FROM `ranking`.`genero`
WHERE `genero` = 'Ação'));

# Insert na tabela jogo_console
INSERT INTO `ranking`.`jogo_console`
(`jogo_id`,
`console_id`)
VALUES
((SELECT `id`
FROM `ranking`.`jogo`
WHERE `titulo` = 'The Legend of Zelda: Ocarina of Time'),
(SELECT `id`
FROM `ranking`.`console`
WHERE `nome` = 'Nintendo 64'));

# Exemplo de jogo 5
# jogo -> ('Skyrim','Bethesda','2011')
# jogo_console -> Playstation 3, Xbox One, Nintendo Switch
# jogo_genero -> Aventura, RPG

######### Exemplo de jogo 5 ###########
# Insert na tabela jogo
INSERT INTO `ranking`.`jogo`
(`titulo`,
`empresa_id`,
`sinopse`,
`urlFoto`)
VALUES
('Grand Theft Auto V',
(SELECT `id`
FROM `ranking`.`empresa`
WHERE `nome` = 'Rockstar Games'),
'Jogo de 2013 no qual o jogador controla três criminosos que arriscam tudo em uma série de golpes ousados na metrópole de Los Santos.',
'assets/images/jogos/gta.jpg');

# Insert na tabela jogo_genero
INSERT INTO `ranking`.`jogo_genero`
(`jogo_id`,
`genero_id`)
VALUES
((SELECT `id`
FROM `ranking`.`jogo`
WHERE `titulo` = 'Grand Theft Auto V'),
(SELECT `id`
FROM `ranking`.`genero`
WHERE `genero` = 'Aventura')),
((SELECT `id`
FROM `ranking`.`jogo`
WHERE `titulo` = 'Grand Theft Auto V'),
(SELECT `id`
FROM `ranking`.`genero`
WHERE `genero` = 'Ação'));

# Insert na tabela jogo_console
INSERT INTO `ranking`.`jogo_console`
(`jogo_id`,
`console_id`)
VALUES
((SELECT `id`
FROM `ranking`.`jogo`
WHERE `titulo` = 'Grand Theft Auto V'),
(SELECT `id`
FROM `ranking`.`console`
WHERE `nome` = 'PC')),
((SELECT `id`
FROM `ranking`.`jogo`
WHERE `titulo` = 'Grand Theft Auto V'),
(SELECT `id`
FROM `ranking`.`console`
WHERE `nome` = 'PlayStation 3')),
((SELECT `id`
FROM `ranking`.`jogo`
WHERE `titulo` = 'Grand Theft Auto V'),
(SELECT `id`
FROM `ranking`.`console`
WHERE `nome` = 'PlayStation 4')),
((SELECT `id`
FROM `ranking`.`jogo`
WHERE `titulo` = 'Grand Theft Auto V'),
(SELECT `id`
FROM `ranking`.`console`
WHERE `nome` = 'Xbox 360')),
((SELECT `id`
FROM `ranking`.`jogo`
WHERE `titulo` = 'Grand Theft Auto V'),
(SELECT `id`
FROM `ranking`.`console`
WHERE `nome` = 'Xbox One'));
