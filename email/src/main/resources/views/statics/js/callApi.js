async function searchAsync(params) {
  const requestParams = new URLSearchParams();
  if (params) {
    if (params.subject) {
      requestParams.set('subject', params.subject);
    }
    if (params.query) {
      requestParams.set('query', params.query);
    }
    if (params.perPage) {
      requestParams.set('perPage', params.perPage);
    }
    if (params.pageNum) {
      requestParams.set('pageNum', params.pageNum);
    }
  }
  return (
    await fetch('/v1/account/?' + requestParams.toString(), {
      method: 'GET',
      credentials: 'same-origin',
    })
  ).json();
}
