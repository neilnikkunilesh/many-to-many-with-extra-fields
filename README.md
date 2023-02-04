# many-to-many-with-extra-fields
#tables that use for this example is follow:

CREATE TABLE book (id integer(11) NOT NULL AUTO_INCREMENT,
name varchar(45) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE publisher (id integer(11) NOT NULL AUTO_INCREMENT,
name varchar(45) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE book_publisher (
id int(11) NOT NULL AUTO_INCREMENT,
published_date datetime NOT NULL,
book_id int(11) NOT NULL,
publisher_id int(11) NOT NULL,
PRIMARY KEY (id),
KEY fk_book (book_id),
KEY fk_publisher (publisher_id),
CONSTRAINT fk_book FOREIGN KEY (book_id) REFERENCES book (id),
CONSTRAINT fk_publisher FOREIGN KEY (publisher_id) REFERENCES publisher (id)
);


https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation


## OneToMany or ManyToOne realtionshinp code for JPA

@Entity
public class Item {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_order")
    private PurchaseOrder order;
 
@Entity
public class PurchaseOrder {
    @OneToMany(mappedBy = "order")
    private List<Item> items = new ArrayList<Item>();
 
}
