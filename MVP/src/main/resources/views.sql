-- View 1: PetDetails
CREATE VIEW PetDetails AS
SELECT p.id_pet, p.nome, p.raca, p.porte, p.observacao, p.data_de_nascimento, u.nome AS usuario_nome
FROM pet p
JOIN usuario u ON p.id_usuario = u.id_usuario;

-- View 2: UserPets
CREATE VIEW UserPets AS
SELECT u.id_usuario, u.nome, COUNT(p.id_pet) AS pet_count
FROM usuario u
LEFT JOIN pet p ON u.id_usuario = p.id_usuario
GROUP BY u.id_usuario, u.nome;

-- View 3: PetAges
CREATE VIEW PetAges AS
SELECT p.id_pet, p.nome, TIMESTAMPDIFF(YEAR, p.data_de_nascimento, CURDATE()) AS age
FROM pet p;

-- View 4: LargePets
CREATE VIEW LargePets AS
SELECT p.id_pet, p.nome, p.raca, p.porte
FROM pet p
WHERE p.porte = 'Grande';

-- View 5: RecentPets
CREATE VIEW RecentPets AS
SELECT p.id_pet, p.nome, p.data_de_nascimento
FROM pet p
WHERE p.data_de_nascimento > DATE_SUB(CURDATE(), INTERVAL 1 YEAR);