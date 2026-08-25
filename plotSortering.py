import pandas as pd
import matplotlib.pyplot as plt
import matplotlib.ticker as ticker
import seaborn as sns

file_path = input("file?")
data = pd.read_csv(file_path)
data.columns = data.columns.str.strip()
sns.set_style("darkgrid") 

# Reshaping dataset for effectivity.
data_lang = pd.melt(
    data,
    id_vars = "n",
    var_name = "algoritme_og_maal",
    value_name = "verdi"
)

# Spliting algorithm and measurment for readability. 
# Using full set for small n
data_lang[["algoritme", "maal"]] = data_lang["algoritme_og_maal"].str.split("_", expand = True)

# Using a downscaled version of the set for large n, othervise it gets quite compact and hard to read.
# We're mostly intrested in the trend. 
data_down = data_lang[data_lang["n"] % 100 == 0]

# Ploting with seaborn
p = sns.relplot(
    data = data_lang,
    x = "n", y = "verdi",
    hue = "algoritme",
    kind = "line",
    row = "maal",
    facet_kws = {"sharey": False}, # Making sure the plots don't share y-axis.
    height = 4, aspect = 2
)

# Changing scale for cmp and swaps to log
y_titles = {"cmp": "Antall Sammenligninger",
            "swaps": "Antall Bytter",
            "time": "Tid (µs)"
}

for ax, maal in zip(p.axes.flatten(), data_lang["maal"].unique()):
    ax.set_ylabel(y_titles[maal])
    ax.tick_params(axis = "x", labelbottom = True)    
    ax.xaxis.set_major_locator(ticker.MaxNLocator(nbins = 10, integer = True))
    if maal in ["cmp", "swaps"]:
        ax.set_yscale("log")

p.set_titles(row_template = "Maaling: {row_name}")
plt.show()