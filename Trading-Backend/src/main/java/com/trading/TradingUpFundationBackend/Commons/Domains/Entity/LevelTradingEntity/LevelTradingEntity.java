package com.trading.TradingUpFundationBackend.Commons.Domains.Entity.LevelTradingEntity;

import com.fasterxml.jackson.annotation.JsonFormat;//Package to send data in Json format
import com.fasterxml.jackson.annotation.JsonManagedReference;//Package to deny the recursion of the side "One"
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.BookTradingEntity.BookTradingEntity;//Import the entity "Book" to represent the relation between these entities
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ClassTradingEntity.ClassTradingEntity;//Import the entity "Class" to represent the relation between these entities
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ExcerciseTradingEntity.ExcerciseTradingEntity;//Import the entity "Excercise" to represent the relation between these entities
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.UserTradingEntity.RegistrationTradingEntity.RegistrationTradingEntity;//Import the entity "Registration" to represent the relation between these entities
import com.trading.TradingUpFundationBackend.Commons.Domains.Entity.ContentTradingEntity.ContentTradingEntity;//Import the entity "Content" to represent the relation between these entities
import jakarta.persistence.*;//Package to add the persistence to this entity
import lombok.Data;//Package of lombok to add the normal methods that an entity has

import java.sql.Date;//Package of lombok to add the normal methods that an entity has
import java.util.List;//Import the type of data "Date" to represent a specific Date

@Entity//Annotation to represent this class like an entity of a database for spring
@Data//Annotation to represent normal methods of a normal class
@Table(name = "level_trading")//Annotation to represent this entity like a table in a database represented with a name
/**
 * Class to represent the entity "level_trading" of the modeling "TradingUpFoundation"
 */
public class LevelTradingEntity {
    @Id//Annotation to represent this attribute like an ID who represent this Entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Annotation who represent the way of how the id is going to work in each registration
    @Column(name = "level_id")//Annotation to represent this attribute like a column with a name in the table
    private Integer id;

    @Column(name = "level_name", length = 255, nullable = false)//Annotation to represent this attribute like a column with a name in the table, the length has to be 255 and it cant be null
    private String name;

    @Column(name = "level_data_start",nullable = false)//Annotation to represent this attribute like a column with a name in the table, cant be null
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataStart;

    @Column(name = "level_data_end", nullable = false)//Annotation to represent this attribute like a column with a name in the table, cant be null
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataEnd;

    @Column(name = "level_amount", nullable = false)//Annotation to represent this attribute like a column with a name in the table, cant be null
    private Integer amount;

    @OneToMany(mappedBy = "levelTradingEntityRelation", cascade = CascadeType.ALL, orphanRemoval = true)//Annotation to represent a relation "One" to "Many" where it is mapped the attribute in the another entity who represent the side "Many"
    @JsonManagedReference//Annotation to do only a query to the entity who represent the side "Many" in the relation
    private List<RegistrationTradingEntity> registrationTradingEntityRelation;

    @OneToMany(mappedBy = "levelTradingEntityRelation", cascade = CascadeType.ALL, orphanRemoval = true)//Annotation to represent a relation "One" to "Many" where it is mapped the attribute in the another entity who represent the side "Many"
    @JsonManagedReference//Annotation to do only a query to the entity who represent the side "Many" in the relation
    private List<ContentTradingEntity> contentTradingEntityRelation;

    @OneToMany(mappedBy = "levelTradingEntityRelation", cascade = CascadeType.ALL, orphanRemoval = true)//Annotation to represent a relation "One" to "Many" where it is mapped the attribute in the another entity who represent the side "Many"
    @JsonManagedReference//Annotation to do only a query to the entity who represent the side "Many" in the relation
    private List<ExcerciseTradingEntity> excerciseTradingEntityRelation;

    @OneToMany(mappedBy = "levelTradingEntityRelation", cascade = CascadeType.ALL, orphanRemoval = true)//Annotation to represent a relation "One" to "Many" where it is mapped the attribute in the another entity who represent the side "Many"
    @JsonManagedReference//Annotation to do only a query to the entity who represent the side "Many" in the relation
    private List<BookTradingEntity> bookTradingEntityRelation;

    @OneToMany(mappedBy = "levelTradingEntityRelation", cascade = CascadeType.ALL, orphanRemoval = true)//Annotation to represent a relation "One" to "Many" where it is mapped the attribute in the another entity who represent the side "Many"
    @JsonManagedReference//Annotation to do only a query to the entity who represent the side "Many" in the relation
    private List<ClassTradingEntity> classTradingEntityRelation;
}
