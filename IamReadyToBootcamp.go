package main

import (
	"bufio"
	"fmt"
	"os"
	"os/exec"
	"strings"

	"github.com/charmbracelet/lipgloss"
)

var (
	errorStyle = lipgloss.NewStyle().Foreground(lipgloss.Color("9"))
	okStyle    = lipgloss.NewStyle().Foreground(lipgloss.Color("10"))
	infoStyle  = lipgloss.NewStyle().Foreground(lipgloss.Color("14"))
)

func main() {
	errorsCount := 0

	file, err := os.Open("requirements.txt")
	if err != nil {
		fmt.Println(errorStyle.Render("[error] не удалось открыть requirements.txt"))
		os.Exit(1)
	}
	defer file.Close()

	type libEntry struct {
		name    string
		version string
	}

	var libs []libEntry
	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		line := strings.TrimSpace(scanner.Text())
		parts := strings.Split(line, "==")
		if len(parts) == 2 {
			libs = append(libs, libEntry{name: parts[0], version: parts[1]})
		}
	}

	var missing []string
	var versionMismatch []string

	for _, lib := range libs {
		cmd := exec.Command("pip3", "show", lib.name)
		output, err := cmd.Output()
		if err != nil {
			missing = append(missing, lib.name)
			errorsCount++
			continue
		}

		lines := strings.Split(string(output), "\n")
		for _, line := range lines {
			if strings.HasPrefix(line, "Version: ") {
				installed := strings.TrimPrefix(line, "Version: ")
				if installed != lib.version {
					versionMismatch = append(versionMismatch, lib.name)
					errorsCount++
				}
				break
			}
		}
	}

	fmt.Println(infoStyle.Render(fmt.Sprintf("[info] всего ошибок: %d", errorsCount)))
	if errorsCount == 0 {
		fmt.Println(okStyle.Render("[ok] УРА! Все работает, ждем тебя на буткемпе!"))
		os.Exit(0)
	}

	fmt.Println(errorStyle.Render("Чет многовато ошибок, попробуй еще раз, мы в тебя верим!\n" +
		"Инструкция: https://github.com/pavelglazunov/cu-bootcamp-2025"))
	if len(missing) > 0 {
		fmt.Println(errorStyle.Render("Пропущенные библиотеки: " + strings.Join(missing, ", ")))
	}
	if len(versionMismatch) > 0 {
		fmt.Println(errorStyle.Render("Библиотеки с ошибкой в версии: " + strings.Join(versionMismatch, ", ")))
	}
	fmt.Println(infoStyle.Render("Используй pip3 install -r requirements.txt"))

	os.Exit(1)
}
