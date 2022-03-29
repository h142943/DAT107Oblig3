drop schema if exists Oblig3 cascade;
create schema Oblig3;
set search_path to Oblig3;

create table ansatt(
ansatt_id Serial primary key,
brukernavn varChar(5) unique,
fornavn varChar(20),
etternavn varChar(20),
ansettelsedato Date,
stilling varChar(20),
manedslonn int,
avdeling_id int,
prosjekt_id int
);

create table avdeling(
avdeling_id Serial primary key,
avd_navn varChar(20),
sjef int not null unique,
foreign key(sjef) references Ansatt(ansatt_id)
);
create table prosjekt(
prosjekt_id serial primary key,
prosjekt_navn varChar(20),
prosjekt_beskrivelse varChar(30),
ansatt_id int,
arbeidstimer int,
prosjekt_rolle varChar(20)
);

insert into
ansatt(brukernavn,fornavn,etternavn,ansettelsedato,stilling,manedslonn, avdeling_id)
values
('a123','per','paalsen','10-10-10','sekretaer',20000,0),
('b123','knut','knutsen','10-10-10','sjef',20000,0),
('c123','askeladd','olsen','10-10-10','sekretaer',20000,1),
('e123','hamsun','knut','10-10-10','sjef',20000,1);
insert into
avdeling(avd_navn, sjef)
values
('hogre',2),
('venstre',3);