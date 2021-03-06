## Datasource settings in application.properties

#### Important: Set to your own local settings!!

Current settings:
* postgresql database on //localhost:5432
* database: Garage
* user/owner: postgres
* password: springboot

#### Seeded users

* admin - password
* user - password

### Endpoints

#### welcome
* GET /welcome

### goodbye
* GET /goodbye

###authenticate
* POST /authenticate

###carmodels
* GET /carmodels
* GET /carmodels/{id}
* DELETE /carmodels/{id}
* POST /carmodels

#### cars
* GET /cars
* GET /cars/{id}
* DELETE /cars/{id}
* POST /cars
* PUT /cars/{id}
* PATCH /cars/{id}

#### customers
* GET /customers
* GET /customers/{id}
* GET /customers/{id}/cars
* DELETE /customers/{id}
* POST /customers
* POST /customers/{id}/cars
* PUT /customers/{id}
* PATCH /customers/{id}

#### spareparts
* GET /spareparts
* GET /spareparts/{id}
* DELETE /spareparts/{id}
* POST /spareparts
* PUT /spareparts/{id}
* PATCH /spareparts/{id}

#### users
* GET /users
* GET /users/{username}
* GET /users/{username}/{authorities}
* DELETE /users/{username}
* DELETE /users/{username}/authorities/{authority}
* POST /users
* POST /users/{username}/authorities
* PUT /users/{username}
* PATCH /users/{username}/password

### api/v1/cars_inspection_repair
* GET /api/v1/cars_inspection_repair
* GET /api/v1/cars_inspection_repair/{id}
* POST /api/v1/cars_inspection_repair
* DELETE /api/v1/cars_inspection_repair/{id}

### api/v1/cars_repair_inspection_shop
* GET /api/v1/cars_repair_inspection_shop
* GET /api/v1/cars_repair_inspection_shop/{id}
* POST /api/v1/cars_repair_inspection_shop
* DELETE /api/v1/cars_repair_inspection_shop/{id}

#### A Postman export has been included in the documentation directory.
### Evenso are the class and the sequence diagrams.
### An example registration certificate has been uploaded to the directory uploads via Postman.

