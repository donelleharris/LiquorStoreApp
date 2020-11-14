USE liquor_store_db;

DROP TABLE liquor_inventory;
DROP TABLE employees;

CREATE TABLE IF NOT EXISTS liquor_inventory(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    brand VARCHAR(255),
    quantity INT,
    category VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO liquor_inventory(brand, quantity, category)
VALUES ('14 Hands', '22', 'WINE'),
    ('Dark Horse', '14', 'WINE'),
    ('Liberty Creek', '14', 'WINE'),
    ('Budweiser','24','BEER'),
    ('Coors','36','BEER'),
    ('Michelob','12','BEER'),
    ('Maker''s Mark','48','WHISKEY'),
    ('Elijah Craig','23','WHISKEY'),
    ('Jack Daniel''s','14','WHISKEY'),
    ('1792','8','BOURBON'),
    ('Woodford Reserve','12','BOURBON'),
    ('Ranger Creek','36','BOURBON'),
    ('Bacardi','22','RUM'),
    ('Captain Morgan','16','RUM'),
    ('Brugal','4','RUM'),
    ('Ciroc','2','VODKA'),
    ('Kettle One','18','VODKA'),
    ('Grey Goose','23','VODKA'),
    ('Johnnie Walker','36','SCOTCH'),
    ('Glenfiddich','24','SCOTCH'),
    ('MaCallan','18','SCOTCH'),
    ('Beefeater','18','GIN'),
    ('Tanqueray','26','GIN'),
    ('Hendrick''s','35','GIN');

CREATE TABLE IF NOT EXISTS employees(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO employees(username, password) VALUES ('donelle', 'harris');