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
    foreign key (cliente_id) references cliente(codigo) on delete cascade
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
    foreign key (produto_id) references produto(codigo) on delete cascade
)

create table venda(
    codigo integer identity primary key,
    cliente_id integer not null,
    data_venda timestamp not null,
    tipo integer not null,
    desconto decimal(30,10) default 0,
    status integer default 0,
    foreign key (cliente_id) references cliente(codigo) on delete cascade
)

create table itemvenda(
    codigo integer identity primary key,
    produto_id integer not null,
    venda_id integer not null,
    valor decimal(30,10) not null,
    quantidade integer default 0,
    foreign key (produto_id) references produto(codigo) on delete cascade,
    foreign key (venda_id) references venda(codigo) on delete cascade
)

create table pagamento(
    codigo integer identity primary key,
    valor decimal(30,10) not null,
    venda_id integer not null,
    data_pagamento timestamp not null,
    pago boolean default false,
    foreign key (venda_id) references venda(codigo) on delete cascade
)

create table funcionario(
    codigo integer identity primary key,
    nome varchar(100),
    quantidadefaltas integer default 0
)