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
('PC',NULL,NULL),
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

# Exemplo de jogo 1
# jogo -> ('Pacman','Bandai Namco','1980')
# jogo_console -> Atari 2600
# jogo_genero -> Plataforma

# Exemplo de jogo 2
# jogo -> ('Super Mario Bros.','Nintendo','1985')
# jogo_console -> NES
# jogo_genero -> Aventura, Plataforma

# Exemplo de jogo 3
# jogo -> ('Sonic the Hedgehog','SEGA','1991')
# jogo_console -> Mega Drive
# jogo_genero -> Aventura, Plataforma

# Exemplo de jogo 4
# jogo -> ('The Legend of Zelda: Ocarina of Time','Nintendo','1998')
# jogo_console -> Nintendo 64
# jogo_genero -> Ação, Aventura

# Exemplo de jogo 5
# jogo -> ('Skyrim','Bethesda','2011')
# jogo_console -> Playstation 3, Xbox One, Nintendo Switch
# jogo_genero -> Aventura, RPG

# Inserir uma avaliação requer a pré preenchimento das tabelas jogo e user
