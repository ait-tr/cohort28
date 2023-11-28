USE db28jpa;

# CREATE TABLE IF NOT EXISTS 'manager'
# (
#     'id'            INT(11)         NOT NULL AUTO_INCREMENT,
#     'manager_name'  VARCHAR(255)    NOT NULL ,
#     'password'      VARCHAR(255)    NOT NULL ,
#     'email'         VARCHAR(255)    NOT NULL,
#     PRIMARY KEY ('id')
# );


INSERT IGNORE INTO `roles` (`name`)
VALUES ('admin'),
        ('user');

INSERT IGNORE INTO `manager` (`manager_name`, `password`, `email`)
VALUES ('administrator', 'pass12345', 'admin@company.com');

