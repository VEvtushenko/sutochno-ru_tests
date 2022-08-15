## <p align="center"> Описание смысла и возможных значений properties для objectProperties </p>
##### <p align="center"> Описание поделено на подразделы в соответствии с разделами UI </p>

### Заголовок    
<p align="center"> String </p>

    name_object:            Заголовок объявления
    self_number_object:     Имя/номер объявления, которые видны только владельцу

### Ваш объект на других ресурсах
<p align="center"> String </p>

    ext_links:              Ссылки на объявления о сдаче в аренду этого объекта на других ресурсах
    
### Вместимость и спальни
<p align="center"> Integer </p>

    bedrooms:               Число спален
    max_guests:             Максимальное число гостей. Не больше чем сумарное число спальных мест
    rooms:                  Число комнат

### Спальные места
<p align="center"> Integer </p>

    single_bed:             Односпальная кровать (1 спальное место на кровать)
    double_bed:             Двуспальная кровать (2 спальных места на кровать)
    king_bed:               Двуспльная широкая (king-size) кровать (2 спальных места на кровать)
    super_king_bed:         Особо широкая двуспальная (super king-size) кровать (2 спальных места на кровать)
    yarus_bed:              Двухъярусная кровать (2 спальных места на кровать)
    bsofa_bed:              Диван-кровать (2 спальных места на кровать)

### Ванная комната
<p align="center"> Integer </p>

    "cnt_bathrooms_toilet": количество ванных комнат
    "cnt_bathrooms":        количество ванных комнат с туалетом
    "cnt_toilets":          количество отдельных туалетов

<p align="center"> boolean </p>

    "bidet":                биде
    "bathrooms":            ванна
    "add_bathroom":         дополнительная ванная
    "add_toilet":           дополнительный туалет
    "bathrobe":             халат
    "cshower":              общий душ/душевая
    "hairdryer":            фен
    "hygienic_shower":      гигиенический душ
    "sauna":                сауна
    "shared_bathroom":      общая ванная комната
    "shared_toilet":        общий туалет
    "shower":               душ
    "slippers":             тапочки
    "toiletries":           туалетные принадлежности
    "towels":               полотенца


### Удобства

###### Общие (boolean)

    "balcony":              балкон
    "condition":            кондиционер
    "bedclothes":           постельное бельё
    "microwave":            СВЧ-печь
    "wifi":                 беспроводной интернет Wi-Fi
    "isolation":            самоизоляция разрешена
    "tv":                   телевизор
    "kettle":               электрический чайник

###### Кухонное оборудование (boolean)

    "bar":                  барная стойка
    "gasstove":             газовая плита
    "coffeemaker":          кофеварка
    "kitchen":              кухонный гарнитур
    "deepfreeze":           морозильник
    "dinner_table":         обеденный стол
    "dishwasher":           посудомоечная машина
    "cutlery":              столовые приборы
    "turka":                турка для приготовления кофе
    "electricrange":        электроплита
    "refrigerator":         холодильник
    "blender":              блендер
    "oven":                 духовка
    "coffee_machine":       кофемашина
    "mini_bar":             мини-бар
    "crockery":             посуда и принадлежности
    "multicooker":          мультиварка
    "Toaster":              тостер
    "waterfilter":          фильтр для воды

###### Оснащение (boolean)

    "fan":                  вентилятор
    "geyser":               газовый водонагреватель,
    "seating_area":         гостиный уголок
    "sofa_bed":             диван-кровать
    "jacuzzi":              джакузи (гидромассажная ванна)
    "ctable":               журнальный столик
    "fireplace":            камин
    "mosquito_net":         москитная сетка
    "linoleum":             линолеум
    "electric_blankets":    одеяла с электроподогревом
    "tiled_marble_floor":   плиточный/мраморный пол
    "desktop":              рабочий стол
    "safe":                 сейф
    "clothesdryer":         сушилка для белья
    "telephone":            телефон
    "heating":              центральное отопление
    "cupboard":             шкаф
    "wheater":              водонагреватель
    "wardrobe":             гардеробная
    "wooden_parquet_floor": деревянный/паркетный пол
    "intercom":             домофон
    "sofa":                 диван
    "soundproofing":        звукоизоляция
    "carpet_covering":      ковровое покрытие
    "laminate":             ламинат
    "steel_door":           металлическая дверь
    "heater":               обогреватель
    "internet":             проводной интернет        
    "pc":                   персональный компьютер
    "folding_bed":          раскладная кровать
    "washmachine":          стиральная машина
    "drying_machine":       сушильная машина
    "iron":                 утюг с гладильной доской
    "cleaning_products":    чистящие средства

###### Для отдыха в помещении (boolean)

    "blu_ray_pl":           blu-ray плеер
    "dvd":                  DVD-проигрыватель
    "consol":               игровая консоль
    "books":                книги
    "tgames":               настольные игры
    "laptop":               ноутбук
    "tv_sattelite":         спутниковое ТВ
    "tv_free":              эфирное ТВ
    "disks":                CD/DVD диски
    "billiards1":           бильярд
    "tv_cable":             кабельное ТВ
    "music_center":         музыкальный центр
    "tabletennis":          настольный теннис
    "radio":                радио
    
###### Оснащение двора (boolean)

    "swimpool1":            бассейн
    "bath1":                баня (на территории)
    "veranda":              веранда
    "garage":               гараж
    "playground":           игровая площадка
    "outdoor_furniture":    мебель на улице
    "security":             охраняемая территория
    "patio":                патио
    "gym":                  спортивный зал
    "barbecue_facilities":  принадлежности для барбекю
    "gridiron":             футбольное поле
    "barbecue":             барбекю/мангал
    "hammok":               гамак
    "arbor":                беседка
    "swing":                детские качели
    "boat":                 лодка
    "outdoor_dining_area":  обеденная зона на улице
    "parking":              парковка
    "gfurniture":           садовая мебель
    "parasol":              пляжный зонтик
    "terrace":              терраса
    "deckchair":            шезлонги
    
###### Для детей (boolean)

    "high_chair_for_child": высокий стул для ребенка
    "games":                игры/игрушки для детей
    "baby_potty":           детский горшок
    "baby_chang_table":     пеленальный стол
    "baby_bed":             детская кроватка
    "safe_window":          защита на окнах
    "baby_bed_m":           кровать-манеж
    "babychair":            стульчик для кормления

### Общие сведения
<p align="center"> String </p>

    "area":                 площадь
    "max_floor":            этажей в доме

    "quality_repair":       ремонт:     -10 - выберите
                                          0 - без ремонта
                                          1 - косметический ремонт
                                          2 - капитальный ремонт "под евро"
                                          3 - дизайнерский евроремонт

    "kitchen_flat":         кухня:        0 - выберите
                                          1 - отдельная кухня
                                          2 - кухня-столовая
                                          3 - кухонная зона
                                         -1 - без кухни
                                     

<p align="center"> Integer </p>

    "floor":                Этаж
<p align="center"> boolean </p>

    "lift":                 Лифт (может быть true только если этажей больше двух)
    "attic_floor":          Мансарда (не может быть true если помещение на первом этаже)

### Вид из окон
<p align="center"> boolean </p>

    "v_city":               на город
    "v_fore":               на лес
    "v_lake":               на озеро
    "v_moun":               на горы
    "v_park":               на парк
    "v_rive":               на реку
    "v_seas":               на море
    "v_strt":               на улицу
    "v_yard":               во двор

### Описание
<p align="center"> String </p>

    "description":          Описание сдаваемого в аренду объекта

### Заезд / отъезд
###### В какое время происходит заселение и выселение?

<p align="center"> String </p>

    "check_in":             расчетное время заезда  (24-х часовой формат, от "1:00" до "23:00")
    "check_out":            расчетное время отъезда (24-х часовой формат, от "1:00" до "23:00")

### Ранний заезд / поздний отъезд
<p align="center"> String </p>

    "check_in_early":       ранний заезд:           2 - по запросу
                                                    3 - с доплатой за предыдущие сутки
                                                    0 - запрещён

    "check_out_early":      поздний отъезд:         2 - по запросу
                                                    3 - с доплатой за предыдущие сутки
                                                    0 - запрещён

### Правила размещения
<p align="center"> String </p>

    "is_children":          гости с детьми:         2 - по запросу
                                                    1 - разрешено
                                                    0 - запрещён

    "party":                проведение вечеринок:   2 - по запросу
                                                    1 - разрешено
                                                    0 - запрещён

    "pets":                 гости с животными:      2 - по запросу
                                                    1 - разрешено
                                                    0 - запрещён

    "smoking":              курение:                1 - разрешено везде
                                                    3 - разрешено в специально отведённых местах
                                                    0 - запрещён 

<p align="center"> String </p>

    "children_age":           возраст ребёнка, начиная с которого разрешено размещение с детьми
                            (только если параметр "is_children" равен "1", возраст - число от 1 до 17)

### Требования к гостю
<p align="center"> boolean </p>

    "is_guest_negative":    не принимать гостей с отрицательными отзывами

### Отчётные документы
<p align="center"> String </p>

    "documents":            предоставление отчётных документов: 1 - предоставляю (без доплаты)
                                                                2 - по запросу
                                                                0 - не предоставляю

### Настройки мгновенного бронирования
<p align="center"> String </p>

    "before_days":          Мгновенное бронирование действует X ней вперёд 
                            (пользователь видит Х/30 месяцев, Х должно быть кратно 30)

    "before_hours":         От бронирования до заселения должно оставаться (часов)

<p align="center"> Integer </p>

    "precost_percent":      Размер предоплаты (выбирается автоматически)

### Цены
<p align="center"> Integer </p>

    "min_nights":           минимальный срок проживания

### Плата за уборку
<p align="center"> String </p>

    "cleaning":             финальная уборка:   2 - включена в стоимость проживания (рекомендуется)
                                                1 - оплачивается отдельно
<p align="center"> Integer </p>

    "gethering":            сколько стоит уборка

### Трансфер
<p align="center"> boolean </p>

    "transfer":             предоставляется трансфер

<p align="center"> String </p>

    "transfer_description": описание условий трансфера

### Страховой депозит
<p align="center"> Integer </p>

    "deposit":              депозит
