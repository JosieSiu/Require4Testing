CREATE TABLE requirement (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    description TEXT
);

CREATE TABLE test_case (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    requirement_id BIGINT,
    FOREIGN KEY (requirement_id) REFERENCES requirement(id)
);

CREATE TABLE test_run (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE test_execution (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    result VARCHAR(50),
    tester_name VARCHAR(255),
    test_case_id BIGINT,
    test_run_id BIGINT,
    FOREIGN KEY (test_case_id) REFERENCES test_case(id),
    FOREIGN KEY (test_run_id) REFERENCES test_run(id)
);
