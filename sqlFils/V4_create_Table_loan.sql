CREATE TABLE loan (
                          id int auto_increment primary key,
                          customer_id int not null,
                          loan_price DECIMAL(15, 2),
                          created_at DATETIME not null,
                          installments DECIMAL(10) not null ,
                          firstInstallments DATETIME not null,
                          FOREIGN KEY (customer_id) REFERENCES customer(id)
);