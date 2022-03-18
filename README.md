# Restaurant_Web_Project
This project uses Springboot. www.start.spring.io to initialize a project, add dependencies and generate. pom.xml
NB: SQLDialect.java class extends Dialect class to allow springboot to tals to SQLdatabase.
Each class created need a repository and controller. 
NB repository is an interface (not a class) that extends JPARepository<name, Integer> {}
NB controller creates http endpoints/routes
In class use annotations: @Entity @Id @GeneratedValue(strategy = GenerationType.AUTO)
In controller: @GETMAPPING @POSTMAPPING @PUTMAPPING @DELETING
to link menus to restaurants     
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    @JsonManagedReference
    private List<Menu> menus;
  @ManyToOne
  @RequestBody Items newItems
  @PathVariable Integer restaurant_id
 
  Use Postman to check http commands work
