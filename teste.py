from datetime import datetime, timedelta

def generate_date_file(filename):
    start_date = datetime(2025, 3, 1)
    end_date = datetime(2025, 12, 31)
    
    with open(filename, "w") as file:
        current_date = start_date
        day_count = 1
        while current_date <= end_date:
            file.write(f"Day {day_count} - {current_date.strftime('%d/%m/%Y')}\n")
            current_date += timedelta(days=1)
            day_count += 1

if __name__ == "__main__":
    generate_date_file("dates_2025.txt")
    print("Arquivo 'dates_2025.txt' gerado com sucesso.")
