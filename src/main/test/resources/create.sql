CREATE MEMORY TABLE IF NOT EXISTS recipes (
id           INTEGER PRIMARY KEY AUTO_INCREMENT,
name         VARCHAR(255),
description  TEXT,
cuisine_type VARCHAR(255)
);

CREATE MEMORY TABLE IF NOT EXISTS ingredients (
  id       INTEGER PRIMARY KEY AUTO_INCREMENT ,
  name     VARCHAR(255),
  calories INT,
  season   VARCHAR(255)
);

CREATE MEMORY TABLE IF NOT EXISTS recipes_ingredients (
  id_recipes_ingredient INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  id_recipes            INTEGER NOT NULL,
  id_ingredients        INTEGER NOT NULL,
  quantity              INT,
  FOREIGN KEY (id_recipes) REFERENCES recipes (id),
  FOREIGN KEY (id_ingredients) REFERENCES ingredients (id)
);

-- INSERT INTO ingredients (name, calories, season) VALUES ('abc', 45 , 'winter');
