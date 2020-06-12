db.createUser(
    {
        user: "root",
        pwd: "123Mudar",
        roles: [
            {
                role: "readWrite",
                db: "test-database"
            }
        ]
    }
);