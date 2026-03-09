const int PINO_SENSOR_TEMPERATURA = A0;
float temperaturaCelcius;

void setup() {
  Serial.begin(9600);

}

void loop() {
  int valorLeitura = analogRead(PINO_SENSOR_TEMPERATURA);
  tmeperaturaCelsius = (valorLeitura * 5.0/1023.0)/ 0.01;

  Serial.print("temperatura: ");
  Serial.print(temperaturaCelsius);
  Serial.print(" C")
  delay(2000);

} 
