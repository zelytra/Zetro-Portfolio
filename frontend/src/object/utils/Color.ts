export function replaceCSSVariables(variables?: { [key: string]: string }) {
  if (!variables) return;
  Object.keys(variables).forEach((variableName) => {
    const variableValue = variables[variableName];
    document.documentElement.style.setProperty(`--${variableName}`, variableValue);
  });
}