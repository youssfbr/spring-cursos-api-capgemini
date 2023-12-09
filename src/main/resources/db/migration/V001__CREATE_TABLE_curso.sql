CREATE TABLE tb_curso (
        id_curso BIGSERIAL NOT NULL,
        valor_curso NUMERIC(38,2),
        nome_curso VARCHAR(30) NOT NULL,

        PRIMARY KEY (id_curso)
);