function parseDateString(date) {
  return (
    `${date.getFullYear()}/` +
    `${('0' + date.getMonth()).slice(-2)}/` +
    `${('0' + date.getDate()).slice(-2)} ` +
    `${('0' + ((date.getHours() + 12) % 24)).slice(-2)}` +
    `${('0' + date.getMinutes()).slice(-2)}` +
    `${('0' + date.getSeconds()).slice(-2)}`
  );
}
