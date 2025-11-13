CREATE TABLE projects (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    start_Date DATE NOT NULL DEFAULT CURRENT_DATE,
    end_Date DATE NOT NULL 
  
);

CREATE TABLE tasks (
    id SERIAL PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL DEFAULT 'TODO',
    priority VARCHAR(50) NOT NULL DEFAULT 'MEDIUM',
    id_project INTEGER NOT NULL,
    start_Date DATE NOT NULL DEFAULT CURRENT_DATE,
    due_Date DATE NOT NULL, 


    CONSTRAINT fk_project
        FOREIGN KEY (id_project)
        REFERENCES projects(id)
        ON DELETE CASCADE
);
