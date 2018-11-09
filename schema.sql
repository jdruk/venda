create table cliente(
    codigo integer identity primary key,
    nome varchar(200),
    planoDeFidelidade boolean DEFAULT FALSE NOT NULL ,
    rg varchar(25)
)

create table endereco(
    codigo integer identity primary key,
    rua varchar(20),
    bairro varchar(20),
    estado varchar(2),
    cliente_id integer,
    foreign key (cliente_id) references cliente(codigo)
)

create table produto(
    codigo integer identity primary key,
    nome varchar(200),
    valor decimal(30,10)
)

create table estoque(
    codigo integer identity primary key,
    produto_id integer,
    quantidade integer default 0,
    foreign key (produto_id) references produto(codigo)
)