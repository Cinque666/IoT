package by.pvt.repository.query;

public enum Query {

    SELECT_FROM_DEVICE("from Device"),
    SELECT_FROM_SENSOR_WHERE_DEVICEID("from Sensor s where s.deviceId = :param"),
    SELECT_FROM_SENSORVALUE_WHERE_SENSORID("from SensorValue where sensorid = :param order by id desc"),
    SELECT_FROM_APPLICATIONUSER_WHERE_USERNAME("from ApplicationUser where username like :param1"),
    SELECT_FROM_DEVICE_DE_WHERE_NAME_LIKE("from Device de where de.name like :param1");


    Query(String query) {
        this.query = query;
    }

    private String query;

    public String getQuery() {
        return query;
    }
}
