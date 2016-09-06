create table point (
	idpoint int(11) primary key,
	long double,
  	lat double,
  	id_quartier int(11) 
);

create table quartier (
  	idQuartier int(11) primary key,
  	nomQuartier varchar(45)
);

ALTER TABLE point
ADD FOREIGN KEY (id_quartier) 
REFERENCES quartier(idQuartier)
