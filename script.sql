-- Active: 1713538740832@@mysql-189a2f27-bossini-testes.d.aivencloud.com@11336@defaultdb

-- 1. Criar uma tabela
-- cod_usuario, login, senha, tipo
CREATE TABLE tb_usuario(
  cod_usuario INT PRIMARY KEY AUTO_INCREMENT,
  login VARCHAR(200) NOT NULL,
  senha VARCHAR(200) NOT NULL,
  tipo INT NOT NULL
);
-- 2. cadastrar dois usuários
INSERT INTO tb_usuario
(login, senha, tipo)
VALUES
('admin', 'admin', 1),
('comum', 'comum', 2);
-- 3. listar os dados dos usuários
SELECT * FROM tb_usuario;

-- 4. Atualizar dados de um usuário
UPDATE tb_usuario SET
login = 'Admin', senha = 'Admin'
WHERE cod_usuario = 1;

-- 5. Apagar um usuário
DELETE FROM tb_usuario
WHERE cod_usuario = 2;

-- 6. Alterar a estrutura da tabela para que ela tenha uma coluna chamada ativo do tipo INT com valor padrão igual a 1 para os existentes (exercício)
ALTER TABLE tb_usuario ADD COLUMN ativo INT DEFAULT 1;