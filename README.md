# UnitConverter 🔧

A powerful and intuitive Android application for converting between various units of measurement. Built with Java, this app provides quick and accurate conversions for length, weight, temperature, volume, and more.

![Platform](https://img.shields.io/badge/platform-Android-green.svg)
![Language](https://img.shields.io/badge/language-Java-orange.svg)
![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Build](https://img.shields.io/badge/build-passing-brightgreen.svg)

## ✨ Features

- **Multiple Unit Categories**: Convert between length, weight, temperature, volume, area, and time units
- **Real-time Conversion**: Instant results as you type
- **Clean Interface**: Material Design principles for intuitive user experience
- **Offline Functionality**: Works without internet connection
- **High Precision**: Accurate calculations with decimal precision
- **Favorites**: Save frequently used conversions for quick access
- **History**: Keep track of recent conversions
- **Dark Mode Support**: Easy on the eyes during night usage

## 📱 Supported Conversions

### 📏 Length
- Meters, Kilometers, Centimeters, Millimeters
- Feet, Inches, Yards, Miles
- Nautical miles, Light years

### ⚖️ Weight/Mass
- Kilograms, Grams, Pounds, Ounces
- Stones, Tons, Metric tons

### 🌡️ Temperature
- Celsius, Fahrenheit, Kelvin
- Rankine, Réaumur

### 🥤 Volume
- Liters, Milliliters, Gallons, Quarts
- Cups, Tablespoons, Teaspoons
- Cubic meters, Cubic feet

### 📐 Area
- Square meters, Square kilometers
- Square feet, Square yards, Acres
- Hectares

### ⏰ Time
- Seconds, Minutes, Hours, Days
- Weeks, Months, Years

## 🛠️ Built With

- **Java** - Primary programming language
- **Android SDK** - Mobile application framework
- **Material Design Components** - UI/UX design system
- **Gradle** - Build automation system
- **Android Studio** - Development environment

## 📋 Requirements

- Android 5.0 (API level 21) or higher
- 10 MB available storage space
- Java 8 compatible device

## 🔧 Installation

### For Users
1. Download the APK from the [Releases](https://github.com/Hilal-Anwar/UnitConverter/releases) section
2. Enable "Install from unknown sources" in your device settings
3. Install the APK file
4. Launch UnitConverter and start converting!

### For Developers
1. **Clone the repository**
git clone https://github.com/Hilal-Anwar/UnitConverter.git

2. **Open in Android Studio**
- Launch Android Studio
- Select "Open an existing Android Studio project"
- Navigate to the cloned repository
- Click "OK"

3. **Build the project**
   ./gradlew build

5. **Run on device/emulator**
   ./gradlew installDebug

## 📂 Project Structure

```
UnitConverter/
├── app/
│ ├── src/
│ │ ├── main/
│ │ │ ├── java/
│ │ │ │ └── com/
│ │ │ │ └── hilal/
│ │ │ │ └── unitconverter/
│ │ │ ├── res/
│ │ │ │ ├── layout/
│ │ │ │ ├── values/
│ │ │ │ ├── drawable/
│ │ │ │ └── mipmap/
│ │ │ └── AndroidManifest.xml
│ │ └── test/
│ └── build.gradle
├── gradle/
│ └── wrapper/
├── .gitignore
├── build.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
└── settings.gradle.kts
```

## 🚀 Usage

1. **Select Category**: Choose the type of unit you want to convert (length, weight, etc.)
2. **Pick Units**: Select the "from" and "to" units from dropdown menus
3. **Enter Value**: Type the value you want to convert
4. **View Result**: See the converted value instantly
5. **Save/Share**: Bookmark frequently used conversions or share results

## 🎨 Screenshots

*Screenshots will be added in the next update*

## 🤝 Contributing

We welcome contributions! Here's how you can help:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Areas for Contribution
- Adding new unit categories (currency, data storage, etc.)
- Improving UI/UX design
- Performance optimizations
- Bug fixes and testing
- Documentation improvements

## 🗺️ Roadmap

- [ ] **Currency Converter**: Real-time exchange rates
- [ ] **Data Storage Units**: Bytes, KB, MB, GB, TB
- [ ] **Speed Conversions**: mph, km/h, m/s, knots
- [ ] **Energy Units**: Joules, calories, BTU, kWh
- [ ] **Widget Support**: Home screen conversion widget
- [ ] **Voice Input**: Convert units using voice commands
- [ ] **Scientific Notation**: Support for very large/small numbers
- [ ] **Unit Calculator**: Perform calculations with different units

## 🐛 Known Issues

- Precision may vary for very large numbers (>10^15)
- Some ancient/historical units are not included

## 📱 Compatibility

- **Minimum SDK**: Android 5.0 (API 21)
- **Target SDK**: Android 13 (API 33)
- **Architecture**: ARM, ARM64, x86, x86_64
- **Screen Sizes**: Phone and tablet optimized

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Hilal Anwar**
- GitHub: [@Hilal-Anwar](https://github.com/Hilal-Anwar)
- Email: [contact@hilalanwar.dev](mailto:contact@hilalanwar.dev)

## 🙏 Acknowledgments

- Google Material Design team for design guidelines
- Android development community for best practices
- Open source contributors who inspire continuous improvement
- Beta testers who provided valuable feedback

## 💡 Fun Facts

- Supports over 50 different units across 6 categories
- Calculations are accurate up to 15 decimal places
- Built with accessibility in mind
- Zero ads, completely free to use

## 📊 Stats

![GitHub stars](https://img.shields.io/github/stars/Hilal-Anwar/UnitConverter?style=social)
![GitHub forks](https://img.shields.io/github/forks/Hilal-Anwar/UnitConverter?style=social)
![GitHub issues](https://img.shields.io/github/issues/Hilal-Anwar/UnitConverter)
![GitHub last commit](https://img.shields.io/github/last-commit/Hilal-Anwar/UnitConverter)

---

⭐ **Found this helpful? Give it a star!** ⭐

*Made with ❤️ by Hilal Anwar*

