-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 22, 2023 at 07:24 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `database_policlinico`
--

-- --------------------------------------------------------

--
-- Table structure for table `citas`
--

CREATE TABLE `citas` (
  `id_citas` int(9) NOT NULL,
  `dni_paciente` int(8) NOT NULL,
  `motivo_visita` text NOT NULL,
  `fecha_cita` varchar(50) NOT NULL,
  `nombres_paciente` varchar(50) NOT NULL,
  `apellidos_pacientes` varchar(50) NOT NULL,
  `genero_paciente` varchar(10) NOT NULL,
  `fecha_de_nacimiento_paciente` date NOT NULL,
  `id_historial` int(11) NOT NULL,
  `nombre_medico` varchar(50) NOT NULL,
  `especialidad_medico` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `citas`
--

INSERT INTO `citas` (`id_citas`, `dni_paciente`, `motivo_visita`, `fecha_cita`, `nombres_paciente`, `apellidos_pacientes`, `genero_paciente`, `fecha_de_nacimiento_paciente`, `id_historial`, `nombre_medico`, `especialidad_medico`) VALUES
(7600999, 7600999, 'Vision nublada', '2023-07-23', 'Martha', 'Achon', 'Femenino', '1990-08-30', 7600999, 'Arnarld Wovcys', 'Oftalmologia'),
(12345098, 12345098, 'Ninguno', '2023-10-22', 'Sheyla', 'Silveira', 'Femenino', '1989-08-15', 12345098, 'Julio Alexander', 'Medicina General'),
(12345678, 12345678, 'Pinchazos en el corazon', '2023/07/25', 'Jessica Marlen', 'Quetzal', 'Femenino', '1990-07-15', 12345678, 'Roger Ortega', 'Cardiologia'),
(23456789, 23456789, 'Alucinaciones producidas por drogas', '2023/07/23', 'Jaime Guadalupe', 'Lastiri', 'Masculino', '1985-03-22', 23456789, 'Pedro Quispe', 'Medicina General'),
(25769184, 25769184, 'Hinchazon en el dedo del pie', '2023/07/23', 'Carolina Del Carmen', 'Valderrama', 'Femenino', '2002-03-22', 25769184, 'Julio Alexander', 'Medicina General'),
(29876543, 29876543, 'Vomitos y fiebre alta - Posible embarazo', '2023/07/23', 'Brenda Maria', 'Ocura', 'Femenino', '1986-07-28', 29876543, 'Diego Rodofdo', 'Medicina General'),
(33428224, 33428224, 'Pinchazos en el corazon', '2023-07-25', 'Juan Alfonso', 'Tosqui', 'Masculino', '2018-12-25', 33428224, 'Rodrigo Aspajo', 'Cardiologia'),
(34567210, 34567210, 'Problemas al respirar, dolor al inhalar', '2023/07/25', 'Marcelino', 'Sencion', 'Masculino', '1985-06-10', 34567210, 'Maria Caceres', 'Neumologia'),
(34567890, 34567890, 'Mancha en el ojo izquierdo', '2023/07/23', 'Uriel Alejandro', 'Reglado', 'Masculino', '1992-11-09', 34567890, 'Arnarld Wovcys', 'Oftalmologia'),
(39876543, 39876543, 'Pinchazos en el corazon', '2023/07/26', 'Cecilia Del Rosario', 'Erdosay', 'Femenino', '1992-03-14', 39876543, 'Rodrigo Aspajo', 'Cardiologia'),
(45678321, 45678321, 'Ninguno', '2023-08-27', 'Susy', 'Jacovo', 'Femenino', '1986-11-25', 45678321, 'Roger Ortega', 'Cardiologia'),
(49876543, 49876543, 'Ruptura craneal ', '2023/07/23', 'Hermenegilda', 'Goyri', 'Femenino', '1988-11-09', 49876543, 'Maria Caceres', 'Neumologia'),
(51420994, 51420994, 'Previa cita a derivacion', '2023/07/24', 'Manuel', 'Sánchez', 'Masculino', '1991-03-27', 51420994, 'Jennifer Markcich', 'Gastroenterologia'),
(70941283, 70941283, 'asfasdfsdf', '2023-07-23', 'Diego', 'Miera', 'Masculino', '2002-04-26', 70941283, 'Diego Rodofdo', 'Medicina General');

-- --------------------------------------------------------

--
-- Table structure for table `diagnosticos`
--

CREATE TABLE `diagnosticos` (
  `id_diagnostico` int(11) NOT NULL,
  `dni_paciente` int(11) NOT NULL,
  `fecha_diagnostico` date NOT NULL,
  `diagnostico_visita` text NOT NULL,
  `plan_tratamiento` text NOT NULL,
  `enfermedad` text NOT NULL,
  `nombres_paciente` text NOT NULL,
  `apellidos_paciente` text NOT NULL,
  `fecha_de_nacimiento_paciente` date NOT NULL,
  `id_historia` int(11) NOT NULL,
  `antecedentes_paciente` text NOT NULL,
  `visitas_paciente` text NOT NULL,
  `tratamiento_paciente` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `diagnosticos`
--

INSERT INTO `diagnosticos` (`id_diagnostico`, `dni_paciente`, `fecha_diagnostico`, `diagnostico_visita`, `plan_tratamiento`, `enfermedad`, `nombres_paciente`, `apellidos_paciente`, `fecha_de_nacimiento_paciente`, `id_historia`, `antecedentes_paciente`, `visitas_paciente`, `tratamiento_paciente`) VALUES
(9, 39876543, '2023-07-22', 'Ninguna', 'Tratamiento para paciente 53', 'Enfermedades para paciente 53', 'Cecilia Del Rosario', 'Erdosay', '1992-03-14', 39876543, 'Antecedentes para paciente 53', 'Ninguna', 'Tratamiento para paciente 53'),
(10, 12345098, '2023-07-22', 'Visita 3', 'Tratamiento para paciente 58', 'Enfermedades para paciente 58', 'Sheyla', 'Silveira', '1989-08-15', 12345098, 'Antecedentes para paciente 58', 'Visita 3', 'Tratamiento para paciente 58');

-- --------------------------------------------------------

--
-- Table structure for table `medicos`
--

CREATE TABLE `medicos` (
  `dni_medico` int(8) NOT NULL,
  `nombre_medico` varchar(50) NOT NULL,
  `apellido_medico` varchar(50) NOT NULL,
  `especialidad_medico` varchar(30) NOT NULL,
  `comentario_admin_de_medico` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `medicos`
--

INSERT INTO `medicos` (`dni_medico`, `nombre_medico`, `apellido_medico`, `especialidad_medico`, `comentario_admin_de_medico`) VALUES
(9856723, 'Rodrigo', 'Aspajo', 'Cardiologia', 'Comentario para 09856723: Ninguno'),
(12367312, 'Roger', 'Ortega', 'Cardiologia', 'Comentario para 12367312: '),
(25623451, 'Diego', 'Rodofdo', 'Medicina General', 'Comentario para 25623451: '),
(83426781, 'Maria', 'Caceres', 'Neumologia', 'Comentario para 83426781: '),
(87834562, 'Julio', 'Alexander', 'Medicina General', 'Comentario para 87834562: Ninguno'),
(90002312, 'Arnarld', 'Wovcys', 'Oftalmologia', 'Comentario para 90002312: Polaco ejerciendo internado'),
(90123412, 'Jennifer', 'Markcich', 'Gastroenterologia', 'Comentario para 90123412: Extranjera'),
(99234123, 'Pedro', 'Quispe', 'Medicina General', 'Comentario para 99234123: Quispe');

-- --------------------------------------------------------

--
-- Table structure for table `pacientes`
--

CREATE TABLE `pacientes` (
  `dni_paciente` int(11) NOT NULL,
  `nombres_paciente` varchar(50) NOT NULL,
  `apellidos_paciente` varchar(50) NOT NULL,
  `genero_paciente` varchar(10) NOT NULL,
  `fecha_de_nacimiento_paciente` date NOT NULL,
  `telefono_paciente` int(10) NOT NULL,
  `contacto_de_emergencia_paciente` int(10) NOT NULL,
  `id_historia` int(11) NOT NULL,
  `antecedentes_paciente` text NOT NULL,
  `enfermedades_paciente` text NOT NULL,
  `visitas_paciente` text NOT NULL,
  `tratamiento_paciente` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pacientes`
--

INSERT INTO `pacientes` (`dni_paciente`, `nombres_paciente`, `apellidos_paciente`, `genero_paciente`, `fecha_de_nacimiento_paciente`, `telefono_paciente`, `contacto_de_emergencia_paciente`, `id_historia`, `antecedentes_paciente`, `enfermedades_paciente`, `visitas_paciente`, `tratamiento_paciente`) VALUES
(7600999, 'Martha', 'Achon', 'Femenino', '1990-08-30', 908876465, 912324152, 7600999, 'Ningun antecedente', 'Ninguno enfermedad', 'Ninguna visita', 'Ninguno tratamiento'),
(8872234, 'Carlos', 'Jhonson', 'Masculino', '2023-04-22', 990992991, 993992321, 8872234, 'Ninguno', 'Ninguno', 'Ninguno', 'Ninguno'),
(9876543, 'Juana Araceli', 'Garciglia', 'Femenino', '1989-10-05', 198765432, 109876543, 9876543, 'Antecedentes para paciente 50', 'Enfermedades para paciente 50', 'Visita 5', 'Tratamiento para paciente 50'),
(12345098, 'Sheyla', 'Silveira', 'Femenino', '1989-08-15', 998765432, 909876543, 12345098, 'Antecedentes para paciente 58', 'Enfermedades para paciente 58', 'Visita 3', 'Tratamiento para paciente 58'),
(12345678, 'Jessica Marlen', 'Quetzal', 'Femenino', '1990-07-15', 912345678, 923456789, 12345678, 'Antecedentes para paciente 41', 'Enfermedades para paciente 41', 'Visita 1', 'Tratamiento para paciente 41'),
(17644523, 'Rosa', 'Matiz', 'Femenino', '1990-03-12', 976456372, 987909887, 17644523, 'Ninguno', 'Ninguno', 'Ninguno', 'Ninguno'),
(19876543, 'Eliecer', 'Coyolt', 'Masculino', '1990-01-20', 298765432, 209876543, 19876543, 'Antecedentes para paciente 51', 'Enfermedades para paciente 51', 'Visita 1', 'Tratamiento para paciente 51'),
(23456109, 'Natanael', 'Simental', 'Masculino', '1993-02-20', 198765432, 919876543, 23456109, 'Antecedentes para paciente 59', 'Enfermedades para paciente 59', 'Visita 4', 'Tratamiento para paciente 59'),
(23456789, 'Jaime Guadalupe', 'Lastiri', 'Masculino', '1985-03-22', 823456789, 834567890, 23456789, 'Antecedentes para paciente 42', 'Enfermedades para paciente 42', 'Visita 2', 'Tratamiento para paciente 42'),
(25174811, 'Juan', 'Pérez', 'Masculino', '1990-05-15', 105209101, 770801191, 25174811, 'Sin antecedentes', 'Ninguna', 'Visita 1', 'Tratamiento inicial'),
(25769184, 'Carolina Del Carmen', 'Valderrama', 'Femenino', '2002-03-22', 385249325, 791251751, 25769184, 'Antecedentes para paciente 38', 'Enfermedades para paciente 38', 'Visita 3', 'Tratamiento para paciente 38'),
(27309709, 'Carlos', 'López', 'Masculino', '1988-12-05', 518545481, 773436167, 27309709, 'Hipertensión', 'Diabetes', 'Visita 2', 'Tratamiento control'),
(29867856, 'Fernando', 'Mata', 'Masculino', '1967-12-09', 967234999, 908123224, 29867856, 'Ninguno', 'Ninguno', 'Ninguno', 'Ninguno'),
(29876543, 'Brenda Maria', 'Ocura', 'Femenino', '1986-07-28', 398765432, 309876543, 29876543, 'Antecedentes para paciente 52', 'Enfermedades para paciente 52', 'Visita 2', 'Tratamiento para paciente 52'),
(31154442, 'Ana', 'Martínez', 'Femenino', '1995-07-30', 237413652, 252435017, 31154442, 'Sin antecedentes', 'Resfriado', 'Visita 1', 'Tratamiento inicial'),
(33428224, 'Juan Alfonso', 'Tosqui', 'Masculino', '2018-12-25', 759850266, 341633171, 33428224, 'Antecedentes para paciente 35', 'Enfermedades para paciente 35', 'Visita 5', 'Tratamiento para paciente 35'),
(34567210, 'Marcelino', 'Sencion', 'Masculino', '1985-06-10', 198765432, 929876543, 34567210, 'Antecedentes para paciente 60', 'Enfermedades para paciente 60', 'Visita 5', 'Tratamiento para paciente 60'),
(34567890, 'Uriel Alejandro', 'Reglado', 'Masculino', '1992-11-09', 734567890, 745678901, 34567890, 'Antecedentes para paciente 43', 'Enfermedades para paciente 43', 'Visita 3', 'Tratamiento para paciente 43'),
(39876543, 'Cecilia Del Rosario', 'Erdosay', 'Femenino', '1992-03-14', 498765432, 409876543, 39876543, 'Antecedentes para paciente 53', 'Enfermedades para paciente 53', 'Ninguna', 'Tratamiento para paciente 53'),
(42861508, 'Beatriz Del Rosario', 'Xinaxtle', 'Femenino', '2020-01-05', 305034553, 170644927, 42861508, 'Antecedentes para paciente 36', 'Enfermedades para paciente 36', 'Visita 1', 'Tratamiento para paciente 36'),
(45678321, 'Susy', 'Jacovo', 'Femenino', '1986-11-25', 198765432, 939876543, 45678321, 'Antecedentes para paciente 61', 'Enfermedades para paciente 61', 'Visita 1', 'Tratamiento para paciente 61'),
(45678901, 'Lizeth Yadira', 'Recendez', 'Femenino', '1988-09-01', 645678901, 656789012, 45678901, 'Antecedentes para paciente 44', 'Enfermedades para paciente 44', 'Visita 4', 'Tratamiento para paciente 44'),
(49876543, 'Hermenegilda', 'Goyri', 'Femenino', '1988-11-09', 598765432, 509876543, 49876543, 'Antecedentes para paciente 54', 'Enfermedades para paciente 54', 'Visita 4', 'Tratamiento para paciente 54'),
(51420994, 'Manuel', 'Sánchez', 'Masculino', '1991-03-27', 981171560, 363227997, 51420994, 'Sin antecedentes', 'Resfriado', 'Visita 2', 'Tratamiento control'),
(53837868, 'María', 'Gómez', 'Femenino', '1985-10-20', 379489870, 282313334, 53837868, 'Alergias', 'Gripe', 'Visita 3', 'Tratamiento actualizado'),
(54993416, 'Pedro', 'González', 'Masculino', '1982-09-12', 992365784, 312026471, 54993416, 'Alergias', 'Ninguna', 'Visita 4', 'Tratamiento actualizado'),
(56789012, 'Nancy Nayeli', 'Gloria', 'Femenino', '1995-05-20', 556789012, 567890123, 56789012, 'Antecedentes para paciente 45', 'Enfermedades para paciente 45', 'Visita 5', 'Tratamiento para paciente 45'),
(56789432, 'Patricia Beatriz', 'Alvineda', 'Femenino', '1992-03-18', 198765432, 949876543, 56789432, 'Antecedentes para paciente 62', 'Enfermedades para paciente 62', 'Visita 2', 'Tratamiento para paciente 62'),
(58303503, 'Laura', 'Hernández', 'Femenino', '1998-11-25', 979095776, 146373817, 58303503, 'Sin antecedentes', 'Gripe', 'Visita 2', 'Tratamiento control'),
(59876543, 'Maria Graciela', 'Visorio', 'Femenino', '1995-05-27', 698765432, 609876543, 59876543, 'Antecedentes para paciente 55', 'Enfermedades para paciente 55', 'Visita 5', 'Tratamiento para paciente 55'),
(67890123, 'Ma. Sofia', 'Antillon', 'Femenino', '1987-12-08', 467890123, 478901234, 67890123, 'Antecedentes para paciente 46', 'Enfermedades para paciente 46', 'Visita 1', 'Tratamiento para paciente 46'),
(69876543, 'Dulce Liliana', 'Domingo', 'Femenino', '1987-09-12', 798765432, 709876543, 56, 'Antecedentes para paciente 56', 'Enfermedades para paciente 56', 'Visita 1', 'Tratamiento para paciente 56'),
(70941283, 'Diego', 'Miera', 'Masculino', '2002-04-26', 910245123, 987456123, 70941283, '2023/02/12 - Presenta fractura en la pierna', '2004/02/12 - Bronquitis\n2010/10/07 - Obesidad', '2004/02/12\n2010/10/07\n2023/02/12', 'Ninguno'),
(71852114, 'Mirian Guadalupe', 'Mezeta', 'Femenino', '2022-03-30', 63580145, 186414623, 71852114, 'Antecedentes para paciente 32', 'Enfermedades para paciente 32', 'Visita 2', 'Tratamiento para paciente 32'),
(74133271, 'Francisco R', 'Ocotl', 'Masculino', '2019-02-19', 513100539, 123243538, 74133271, 'Antecedentes para paciente 33', 'Enfermedades para paciente 33', 'Visita 3', 'Tratamiento para paciente 33'),
(76423648, 'Elmario', 'Roseta', 'Masculino', '1996-09-12', 978653221, 998763450, 76423648, 'Ninguno', 'Ninguna', 'Ninguno', 'Ninguno'),
(78901234, 'Luis', 'Tepayotl', 'Masculino', '1991-04-18', 378901234, 389012345, 78901234, 'Antecedentes para paciente 47', 'Enfermedades para paciente 47', 'Visita 2', 'Tratamiento para paciente 47'),
(79458179, 'Gabriel', 'Rojas', 'Masculino', '1987-04-18', 533787528, 285192302, 79458179, 'Hipertensión', 'Diabetes', 'Visita 3', 'Tratamiento actualizado'),
(79876543, 'Sonia Imelda', 'Calzoncit', 'Femenino', '1991-01-30', 898765432, 809876543, 79876543, 'Antecedentes para paciente 57', 'Enfermedades para paciente 57', 'Visita 2', 'Tratamiento para paciente 57'),
(80051081, 'Juan German', 'Cuamatzin', 'Masculino', '2004-09-14', 742461764, 825912354, 80051081, 'Antecedentes para paciente 39', 'Enfermedades para paciente 39', 'Visita 4', 'Tratamiento para paciente 39'),
(82459895, 'Sofía', 'Díaz', 'Femenino', '1992-08-09', 267417915, 863292732, 82459895, 'Alergias', 'Ninguna', 'Visita 1', 'Tratamiento inicial'),
(87262533, 'Lucía', 'Torres', 'Femenino', '1996-06-14', 273442718, 749337615, 87262533, 'Hipertensión', 'Gripe', 'Visita 3', 'Tratamiento actualizado'),
(89012345, 'Maria Evelia', 'Ayabar', 'Femenino', '1993-08-27', 289012345, 290123456, 89012345, 'Antecedentes para paciente 48', 'Enfermedades para paciente 48', 'Visita 3', 'Tratamiento para paciente 48'),
(90123456, 'Berta', 'Ferrusca', 'Femenino', '1984-06-10', 190123456, 101234567, 90123456, 'Antecedentes para paciente 49', 'Enfermedades para paciente 49', 'Visita 4', 'Tratamiento para paciente 49'),
(90217650, 'Nidia Gabriela', 'Marruffo', 'Femenino', '2022-07-25', 459198037, 196553700, 90217650, 'Antecedentes para paciente 40', 'Enfermedades para paciente 40', 'Visita 5', 'Tratamiento para paciente 40'),
(93470899, 'Enrique Martin', 'Deleon', 'Masculino', '2001-01-08', 954257991, 516259017, 93470899, 'Antecedentes para paciente 31', 'Enfermedades para paciente 31', 'Visita 1', 'Tratamiento para paciente 31'),
(93812100, 'Alicia Del Carmen', 'Ortegon', 'Femenino', '2018-03-14', 78988455, 858931437, 93812100, 'Antecedentes para paciente 37', 'Enfermedades para paciente 37', 'Visita 2', 'Tratamiento para paciente 37');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `rol` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `password`, `rol`) VALUES
(1, 'Administrador', 'admin', 'Administrador'),
(2, 'Medico', 'medico', 'Medico');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`id_citas`),
  ADD KEY `fk_paciente` (`dni_paciente`);

--
-- Indexes for table `diagnosticos`
--
ALTER TABLE `diagnosticos`
  ADD PRIMARY KEY (`id_diagnostico`),
  ADD KEY `dni_paciente` (`dni_paciente`);

--
-- Indexes for table `medicos`
--
ALTER TABLE `medicos`
  ADD PRIMARY KEY (`dni_medico`);

--
-- Indexes for table `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`dni_paciente`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `citas`
--
ALTER TABLE `citas`
  MODIFY `id_citas` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70941284;

--
-- AUTO_INCREMENT for table `diagnosticos`
--
ALTER TABLE `diagnosticos`
  MODIFY `id_diagnostico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `medicos`
--
ALTER TABLE `medicos`
  MODIFY `dni_medico` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=99234124;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `citas`
--
ALTER TABLE `citas`
  ADD CONSTRAINT `fk_paciente` FOREIGN KEY (`dni_paciente`) REFERENCES `pacientes` (`dni_paciente`);

--
-- Constraints for table `diagnosticos`
--
ALTER TABLE `diagnosticos`
  ADD CONSTRAINT `diagnosticos_ibfk_1` FOREIGN KEY (`dni_paciente`) REFERENCES `pacientes` (`dni_paciente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
