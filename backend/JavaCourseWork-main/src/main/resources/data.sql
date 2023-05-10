INSERT INTO role (id, name) VALUES (1, 'USER');
INSERT INTO role (id, name) VALUES (2, 'ADMIN');

INSERT INTO users (login, password) VALUES ('admin', 'admin');

INSERT INTO book (id, description, name, price, category, author, quantity, image)
    VALUES (1, 'Фантастика', 'Солярис', 899, 'fantasy', 'Станислав Лем', 6, '/img/fantasy1.jpg');
INSERT INTO book (id, description, name, price, category, author, quantity, image)
    VALUES (2, 'Фантастика', 'Дюна', 699, 'fantasy', 'Фрэнк Герберт', 15, '/img/fantasy2.jpg');
INSERT INTO book (id, description, name, price, category, author, quantity, image)
    VALUES (3, 'Фантастика', 'Анафем', 1299, 'fantasy', 'Нил Стивенсон', 8, '/img/fantasy3.jpg');
INSERT INTO book (id, description, name, price, category, author, quantity, image)
    VALUES (4, 'Фантастика', 'Гиперион', 1599, 'fantasy', 'Дэн Симмонс', 3, '/img/fantasy4.jpg');

INSERT INTO book (id, description, name, price, category, author, quantity, image)
    VALUES (5, 'Проза', 'Ненастье', 1199, 'prose', 'Алексей Иванов', 21, '/img/prose1.jpg');
INSERT INTO book (id, description, name, price, category, author, quantity, image)
    VALUES (6, 'Проза', 'День опричника', 1599, 'prose', 'Владимир Сорокин', 2, '/img/prose2.jpg');
INSERT INTO book (id, description, name, price, category, author, quantity, image)
    VALUES (7, 'Проза', 'Кысь', 599, 'prose', 'Татьяна Толстая', 11, '/img/prose3.jpg');
INSERT INTO book (id, description, name, price, category, author, quantity, image)
    VALUES (8, 'Проза', 'Каторга', 799, 'prose', 'Валентин Пикуль', 6, '/img/prose4.jpg');

INSERT INTO book (id, description, name, price, category, author, quantity, image)
    VALUES (9, 'Детектив', 'Убийство на улице Морг', 799, 'detective', 'Эдгар Аллан По', 10, '/img/detective1.jpg');
INSERT INTO book (id, description, name, price, category, author, quantity, image)
    VALUES (10, 'Детектив', 'Лунный камень', 499, 'detective', 'Уилки Коллинз', 4, '/img/detective2.jpg');
INSERT INTO book (id, description, name, price, category, author, quantity, image)
    VALUES (11, 'Детектив', 'Загадка Эндхауза', 899, 'detective', 'Агата Кристи', 6, '/img/detective3.jpg');
INSERT INTO book (id, description, name, price, category, author, quantity, image)
    VALUES (12, 'Детектив', 'Рассказы о Шерлоке Холмсе', 1899, 'detective', 'Артур Конан Дойл', 2, '/img/detective4.jpg');

INSERT INTO book (id, description, name, price, category, author, quantity, image)
    VALUES (13, 'Научно-популярная литература', '21 урок для XXI века', 1199, 'non-fiction', 'Юваль Ной Харари', 8, '/img/non-fiction1.jpg');
INSERT INTO book (id, description, name, price, category, author, quantity, image)
    VALUES (14, 'Научно-популярная литература', 'Чёрный лебедь', 1799, 'non-fiction', 'Нассим Николас Талеб', 16, '/img/non-fiction2.jpg');
INSERT INTO book (id, description, name, price, category, author, quantity, image)
    VALUES (15, 'Научно-популярная литература', 'Осознанность. Как обрести гармонию в нашем безумном мире', 999,
    'non-fiction', 'Денни Пенман', 15, '/img/non-fiction3.jpg');
INSERT INTO book (id, description, name, price, category, author, quantity, image)
    VALUES (16, 'Научно-популярная литература', 'Думай медленно… решай быстро', 999,
    'non-fiction', 'Даниэль Канеман', 0, '/img/non-fiction4.jpg');
