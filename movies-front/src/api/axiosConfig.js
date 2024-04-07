import axios from "axios";

export default axios.create({
  baseURL: "https://ad3f-2806-230-1306-c313-341a-db1-fcc-1b13.ngrok-free.app/",
  headers: { "ngrok-skip-browser-warning": "true" },
});
