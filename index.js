const express = require('express');
const app = express();
const port = 3000;

app.use(express.json());

app.post("/sort", (req, res) => {
    const { sort_order, values } = req.body;
    if (sort_order !== "asc" && sort_order !== "desc") {
        res.json({ "sort_order": "false value"});
        return;
    }
    else if (!Array.isArray(values) || values.length < 2 || !values.every(item => typeof item === 'number')) {
        res.json({ "values": "not a list of numbers"});
        return;
    }
    if (sort_order === "asc")
        res.json(values.sort());
    else
        res.json(values.sort().reverse());
});

app.listen(port, async () => {
    console.log(`Serveur démarré sur http://localhost:${port}`);
});
