CREATE TABLE T_FLO_ENDERECO(
  cd_endereco INTEGER PRIMARY KEY NOT NULL,
  ds_logradouro VARCHAR(50),
  nr_endereco VARCHAR(20),
  nm_complemento VARCHAR(200),
  nm_bairro VARCHAR(120),
  nm_cidade VARCHAR(120),
  sg_estado VARCHAR(2),
  nr_cep VARCHAR(9) NOT NULL
);

create table T_FLO_TIPO_USUARIO(
  cd_tipo_usuario INTEGER PRIMARY KEY,
  ds_tipo_usuario VARCHAR(120) NULL
);

create table T_FLO_USUARIO(
  cd_usuario INTEGER PRIMARY KEY,
  cd_tipo_usuario INTEGER NOT NULL,
  tx_nome VARCHAR(100) NOT NULL,
  tx_email VARCHAR(50) NOT NULL,
  tx_senha VARCHAR(20) NOT NULL,
  dt_nascimento DATE NOT NULL,
  qt_ponto INTEGER NULL,
  img_usuario VARCHAR(255),
  FOREIGN KEY(cd_tipo_usuario) references T_FLO_TIPO_USUARIO (cd_tipo_usuario)
);

create table T_FLO_INSTITUICAO(
    cd_instituicao INTEGER PRIMARY KEY,
    nm_instituicao varchar(30) not null,
    ds_tipo_instituicao varchar(7),
    ds_instituicao varchar(234),
    img_instituicao VARCHAR(255)
);

create table T_FLO_INSTITUICAO_UNIDADE(
    cd_instituicao INTEGER NOT NULL,
    cd_endereco INTEGER NOT NULL,
    PRIMARY KEY(cd_instituicao,cd_endereco),
    FOREIGN KEY (cd_instituicao) REFERENCES T_FLO_INSTITUICAO(cd_instituicao),
    FOREIGN KEY (cd_endereco) REFERENCES T_FLO_ENDERECO(cd_endereco) 
);

create table T_FLO_CATALOGO(
    cd_catalogo INTEGER PRIMARY KEY,
    ds_catalogo varchar(50) NULL
);

create table T_FLO_CURSO(
    cd_curso INTEGER PRIMARY KEY,
    cd_catalogo INTEGER not null,
    nm_curso varchar(40) not null,
    FOREIGN KEY (cd_catalogo) REFERENCES T_FLO_CATALOGO (cd_catalogo)
);

create table T_FLO_INSTITUICAO_CURSO(
    cd_curso INTEGER not null,
    cd_instituicao INTEGER not null,
    nr_nota_mec DECIMAL(10,2) not null,
    tp_curso DECIMAL(10,2) not null,
    ds_tipo_curso varchar(50),
    st_bolsa char(1) not null,
    vl_bolsa DECIMAL(10,2) not null,
    nr_like INTEGER not null,
    nr_dislike INTEGER not null,
    video varchar(255) null,
    ds_curso clob null,
    ds_plano_carreira clob null,
    PRIMARY KEY (cd_curso,cd_instituicao),
    FOREIGN KEY (cd_curso) REFERENCES T_FLO_CURSO(cd_curso),
    FOREIGN KEY (cd_instituicao) REFERENCES T_FLO_INSTITUICAO(cd_instituicao) 
);

create table T_FLO_TOPICO(
    cd_topico INTEGER PRIMARY KEY,
    cd_curso INTEGER not null,
    cd_usuario INTEGER not null,
    tx_titulo VARCHAR(50) not null,
    tx_duvida VARCHAR(350) not null,
    st_solucionado char(1) not null,    
    FOREIGN KEY (cd_curso) references T_FLO_CURSO (cd_curso),
    FOREIGN KEY (cd_usuario) references T_FLO_USUARIO (cd_usuario)
);

create table T_FLO_COMENTARIO(
    cd_comentario INTEGER PRIMARY KEY,
    cd_topico INTEGER not null,
    cd_usuario INTEGER not null,
    st_solucao char(1) not null,
    tx_resposta varchar(350) not null,    
    FOREIGN KEY (cd_topico) REFERENCES T_FLO_TOPICO (cd_topico),
    FOREIGN KEY (cd_usuario) REFERENCES T_FLO_USUARIO (cd_usuario)
);


create table T_FLO_FEEDBACK(
    cd_feedback INTEGER PRIMARY KEY,
    cd_usuario INTEGER not null,
    cd_instituicao INTEGER not null,
    cd_curso INTEGER not null,
    ds_feedback varchar(120) not null,
    nr_curso INTEGER not null,
    nr_like INTEGER not null,
    nr_dislike INTEGER,
    FOREIGN KEY(cd_usuario) REFERENCES T_FLO_USUARIO(cd_usuario),
    FOREIGN KEY(cd_instituicao) REFERENCES T_FLO_INSTITUICAO(cd_instituicao),
    FOREIGN KEY(cd_curso) REFERENCES T_FLO_CURSO(cd_curso)
);

create table T_FLO_CERTIFICADO(
    cd_usuario INTEGER,
    cd_instituicao INTEGER not null,   
    cd_curso INTEGER not null,
    img_certificado VARCHAR(255) not null,
    dt_conclusao date not null,
    FOREIGN KEY(cd_usuario) REFERENCES T_FLO_USUARIO(cd_usuario),
    FOREIGN KEY(cd_instituicao) REFERENCES T_FLO_INSTITUICAO(cd_instituicao),
    FOREIGN KEY(cd_curso) REFERENCES T_FLO_CURSO(cd_curso),
    PRIMARY KEY(cd_usuario,cd_instituicao,cd_curso)
);

create table T_FLO_PREMIACAO(
  cd_premiacao INTEGER PRIMARY KEY,
  dt_inicio date not null,
  dt_fim date
);

create table T_FLO_VENCEDOR(
    cd_premiacao INTEGER PRIMARY KEY,
    cd_usuario INTEGER not null,
    FOREIGN KEY(cd_premiacao) REFERENCES T_FLO_PREMIACAO(cd_premiacao),
    FOREIGN KEY(cd_usuario) REFERENCES T_FLO_USUARIO(cd_usuario)
);


create table T_FLO_ESQUEMA_PONTO(
  cd_ponto INTEGER PRIMARY KEY,
  nm_ponto varchar(30) not null,
  qt_ponto INTEGER not null
);

create table T_FLO_CONTADOR_PONTO(
  cd_contador INTEGER PRIMARY KEY,
  cd_ponto INTEGER not null,
  cd_premiacao INTEGER not null,
  cd_usuario INTEGER not null,
  dt_contagem date not null,
  st_ponto_adicionado char(1) not null,   
  FOREIGN KEY(cd_premiacao) REFERENCES T_FLO_PREMIACAO(cd_premiacao),
  FOREIGN KEY(cd_usuario) REFERENCES T_FLO_USUARIO(cd_usuario),
  FOREIGN KEY(cd_ponto) REFERENCES T_FLO_ESQUEMA_PONTO(cd_ponto)
);

CREATE SEQUENCE SQ_FLO_CATALOGO;
CREATE SEQUENCE SQ_FLO_COMENTARIO;
CREATE SEQUENCE SQ_FLO_CONTADOR_PONTO;
CREATE SEQUENCE SQ_FLO_CURSO;
CREATE SEQUENCE SQ_FLO_ESQUEMA_PONTO;
CREATE SEQUENCE SQ_FLO_FEEDBACK;
CREATE SEQUENCE SQ_FLO_INSTITUICAO;
CREATE SEQUENCE SQ_FLO_PREMIACAO;
CREATE SEQUENCE SQ_FLO_TIPO_USUARIO;
CREATE SEQUENCE SQ_FLO_TOPICO;
CREATE SEQUENCE SQ_FLO_USUARIO;
CREATE SEQUENCE SQ_FLO_ENDERECO;

CREATE TRIGGER TR_FLO_CATALOGO BEFORE INSERT ON T_FLO_CATALOGO
FOR EACH ROW
BEGIN
    SELECT SQ_FLO_CATALOGO.NEXTVAL INTO :NEW.CD_CATALOGO FROM DUAL;
END;

CREATE TRIGGER TR_FLO_COMENTARIO BEFORE INSERT ON T_FLO_COMENTARIO
FOR EACH ROW
BEGIN
    SELECT SQ_FLO_COMENTARIO.NEXTVAL INTO :NEW.CD_COMENTARIO FROM DUAL;
END;

CREATE TRIGGER TR_FLO_CONTADOR_PONTO BEFORE INSERT ON T_FLO_CONTADOR_PONTO
FOR EACH ROW
BEGIN
    SELECT SQ_FLO_CONTADOR_PONTO.NEXTVAL INTO :NEW.CD_CONTADOR FROM DUAL;
END;

CREATE TRIGGER TR_FLO_CURSO BEFORE INSERT ON T_FLO_CURSO
FOR EACH ROW
BEGIN
    SELECT SQ_FLO_CURSO.NEXTVAL INTO :NEW.CD_CURSO FROM DUAL;
END;

CREATE TRIGGER TR_FLO_ESQUEMA_PONTO BEFORE INSERT ON T_FLO_ESQUEMA_PONTO
FOR EACH ROW
BEGIN
    SELECT SQ_FLO_ESQUEMA_PONTO.NEXTVAL INTO :NEW.CD_PONTO FROM DUAL;
END;

CREATE TRIGGER TR_FLO_FEEDBACK BEFORE INSERT ON T_FLO_FEEDBACK
FOR EACH ROW
BEGIN
    SELECT SQ_FLO_FEEDBACK.NEXTVAL INTO :NEW.CD_FEEDBACK FROM DUAL;
END;

CREATE TRIGGER TR_FLO_INSTITUICAO BEFORE INSERT ON T_FLO_INSTITUICAO
FOR EACH ROW
BEGIN
    SELECT SQ_FLO_INSTITUICAO.NEXTVAL INTO :NEW.CD_INSTITUICAO FROM DUAL;
END;

CREATE TRIGGER TR_FLO_PREMIACAO BEFORE INSERT ON T_FLO_PREMIACAO
FOR EACH ROW
BEGIN
    SELECT SQ_FLO_PREMIACAO.NEXTVAL INTO :NEW.CD_PREMIACAO FROM DUAL;
END;

CREATE TRIGGER TR_FLO_TIPO_USUARIO BEFORE INSERT ON T_FLO_TIPO_USUARIO
FOR EACH ROW
BEGIN
    SELECT SQ_FLO_TIPO_USUARIO.NEXTVAL INTO :NEW.CD_TIPO_USUARIO FROM DUAL;
END;

CREATE TRIGGER TR_FLO_TOPICO BEFORE INSERT ON T_FLO_TOPICO
FOR EACH ROW
BEGIN
    SELECT SQ_FLO_TOPICO.NEXTVAL INTO :NEW.CD_TOPICO FROM DUAL;
END;

CREATE TRIGGER TR_FLO_USUARIO BEFORE INSERT ON T_FLO_USUARIO
FOR EACH ROW
BEGIN
    SELECT SQ_FLO_USUARIO.NEXTVAL INTO :NEW.CD_USUARIO FROM DUAL;
END;

CREATE TRIGGER TR_FLO_ENDERECO BEFORE INSERT ON T_FLO_ENDERECO
FOR EACH ROW
BEGIN
    SELECT SQ_FLO_ENDERECO.NEXTVAL INTO :NEW.CD_ENDERECO FROM DUAL;
END;
