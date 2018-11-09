create table cliente(
    codigo integer identity primary key,
    nome varchar(200) not null,
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
    produto_id integer not null,
    quantidade integer default 0,
    foreign key (produto_id) references produto(codigo)
)

create table venda(
    codigo integer identity primary key,
    cliente_id integer not null,
    data_venda datetime not null,
    total decimal(30,10) default 0.0,
    status integer default 0,
    foreign key (cliente_id) references cliente(codigo)
)

create table itemvenda(
    codigo integer identity primary key,
    produto_id integer not null,
    venda_id integer not null,
    valor decimal(30,10) not null,
    foreign key (produto_id) references produto(codigo),
    foreign key (venda_id) references venda(codigo)
)