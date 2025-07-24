INSERT INTO questions (id, description, technology) VALUES
('550e8400-e29b-41d4-a716-446655440000', 'Qual a melhor linguagem de programação?', 'JAVA'),
('550e8400-e29b-41d4-a716-446655440099', 'Qual framework Java é usado para desenvolvimento web?', 'JAVA'),
('550e8400-e29b-41d4-a716-446655440011', 'Qual ferramenta é usada para gerenciamento de dependências no Java?', 'JAVA');

-- Inserir alternativas para pergunta 1 (apenas 1 correta)
INSERT INTO alternatives (id, question_id, description, is_correct) VALUES
('550e8400-e29b-41d4-a716-446655440035', '550e8400-e29b-41d4-a716-446655440000', 'Java é a melhor', TRUE),
('550e8400-e29b-41d4-a716-435436465747', '550e8400-e29b-41d4-a716-446655440000', 'Python é melhor para dados', FALSE),
('550e8400-e29b-41d4-a716-768678780700', '550e8400-e29b-41d4-a716-446655440000', 'JavaScript é melhor para web', FALSE),
('550e8400-e29b-41d4-a716-676789696969', '550e8400-e29b-41d4-a716-446655440000', 'C++ é melhor para jogos', FALSE);

-- Inserir alternativas para pergunta 2 (apenas 1 correta)
INSERT INTO alternatives (id, question_id, description, is_correct) VALUES
('550e8400-e29b-41d4-a716-423424242424', '550e8400-e29b-41d4-a716-446655440099', 'Spring Boot', TRUE),
('550e8400-e29b-41d4-a716-867867969999', '550e8400-e29b-41d4-a716-446655440099', 'Django', FALSE),
('550e8400-e29b-41d4-a716-768769679800', '550e8400-e29b-41d4-a716-446655440099', 'React', FALSE),
('550e8400-e29b-41d4-a716-646546354342', '550e8400-e29b-41d4-a716-446655440099', 'Angular', FALSE);

-- Inserir alternativas para pergunta 3 (apenas 1 correta)
INSERT INTO alternatives (id, question_id, description, is_correct) VALUES
('550e8400-e29b-41d4-a716-675675686888', '550e8400-e29b-41d4-a716-446655440011', 'Maven', TRUE),
('550e8400-e29b-41d4-a716-797846546435', '550e8400-e29b-41d4-a716-446655440011', 'Gradle', FALSE),
('550e8400-e29b-41d4-a716-658679646535', '550e8400-e29b-41d4-a716-446655440011', 'NPM', FALSE),
('550e8400-e29b-41d4-a716-435364575688', '550e8400-e29b-41d4-a716-446655440011', 'Yarn', FALSE);